package com.lgw.coolweather.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import com.lgw.coolweather.R;
import com.lgw.coolweather.utils.LogUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2016-01-15.
 */
public class DBManager {
    public final String TAG = "DBManager___________";
    private final int BUFFER_SIZE = 400000;
    public static final String DB_NAME = "chinacities.db";
    public static final String PACKAGE_NAME = "com.lgw.coolweather";
    public static final String DB_PATH = "/data"
            + Environment.getDataDirectory().getAbsolutePath()
            + "/" + PACKAGE_NAME;
    private SQLiteDatabase database;
    private Context context;

    public DBManager(Context context) {
        this.context = context;
    }

    public void openDatabase() {
        this.database = this.openDatabase(DB_PATH + "/" + DB_NAME);
    }

    private SQLiteDatabase openDatabase(String dbfile) {
        try {
            if (!(new File(dbfile).exists())) {
                InputStream ins = this.context.getResources().openRawResource(R.raw.chinacities);
                FileOutputStream fous = new FileOutputStream(dbfile);
                byte[] buffer = new byte[BUFFER_SIZE];
                int count;
                while ((count = ins.read(buffer)) > 0) {
                    fous.write(buffer, 0, count);
                }
                fous.flush();
                fous.close();
                ins.close();
            }
            return SQLiteDatabase.openOrCreateDatabase(dbfile, null);
        } catch (FileNotFoundException e) {
            LogUtil.i(TAG, "FileNotFoundException");
            e.printStackTrace();
        } catch (IOException e) {
            LogUtil.i(TAG, "IOException");
            e.printStackTrace();
        }

        return null;
    }

    public void closeDatabase() {
        this.database.close();
    }
}
