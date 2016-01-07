package com.lgw.coolweather.db;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.lgw.coolweather.utils.LogUtil;

/**
 * Created by Administrator on 2016-01-07.
 */
public class DbHelper extends SQLiteOpenHelper {
    private Context mContext;
    public static final String TAG = "DbHelper__________";
    public static final String CREATE_CITY_TABLE = "create table City (" +
            "ID integer primary key autoincrement," +
            "AREAID integer," +
            "NAMEEN varchar," +
            "NAMECN varchar," +
            "DISTRICTEN varchar," +
            "DISTRICTCN varchar," +
            "PROVEN varchar," +
            "PROVCN varchar," +
            "NATIONEN varchar," +
            "NATIONCN varchar)";

    public DbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }
//    public DbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version,
//                    DatabaseErrorHandler errorHandler) {
//        super(context, name, factory, version, errorHandler);
//    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_CITY_TABLE);
        LogUtil.i(TAG, "数据库创建成功");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
