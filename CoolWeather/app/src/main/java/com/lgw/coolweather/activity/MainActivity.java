package com.lgw.coolweather.activity;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.lgw.coolweather.R;
import com.lgw.coolweather.constant.MainMessage;
import com.lgw.coolweather.constant.RequestData;
import com.lgw.coolweather.db.DBManager;
import com.lgw.coolweather.httpclient.HttpConnectionTool;
import com.lgw.coolweather.model.city.City;
import com.lgw.coolweather.utils.JsonObjectTool;
import com.lgw.coolweather.utils.LogUtil;

import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;


public class MainActivity extends Activity implements View.OnClickListener {
    public String TAG = "MainActivity_____________________";
    public EditText city;
    public Button search;
    public TextView msg_tv;
    public SQLiteDatabase database;
    private ArrayList<City> cities;
    public Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MainMessage.SHOW_RESPONSE:
                    String response = (String) msg.obj;
                    msg_tv.setText(response);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        city = (EditText) findViewById(R.id.editCity);
        search = (Button) findViewById(R.id.search);
        msg_tv = (TextView) findViewById(R.id.msg);
        search.setOnClickListener(this);
    }

    private void sendRequestWithHttpURLConnection() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                database = SQLiteDatabase.openOrCreateDatabase(DBManager.DB_PATH + "/" + DBManager.DB_NAME, null);
                StringBuffer sb = null;
                String response = null;
                cities = getCity();
                int i = cities.size();
                LogUtil.i(TAG, i + "________________________");
                for (City city : cities) {
                    response = city.getID() + "\n" +
                            city.getAREAID() + "\n" +
                            city.getNAMEEN() + "\n" +
                            city.getNAMECN() + "\n" +
                            city.getDISTRICTEN() + "\n" +
                            city.getDISTRICTCN() + "\n" +
                            city.getPROVEN() + "\n" +
                            city.getPROVCN() + "\n" +
                            city.getNATIONEN() + "\n" +
                            city.getNATIONCN() + "\n";
//                    LogUtil.i(TAG, response);
//                    sb.append(response);
                }
                Message message = new Message();
                message.what = MainMessage.SHOW_RESPONSE;
                message.obj = response;
                handler.sendMessage(message);
            }
        }).start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.search:
                String cities = city.getText().toString();
                LogUtil.i(TAG, "" + cities);
                if (cities.equals("")) {
                    DBManager dbManager = new DBManager(this);
                    dbManager.openDatabase();
                    dbManager.closeDatabase();
                    Toast.makeText(getApplicationContext(), "数据库导入成功", Toast.LENGTH_SHORT).show();
                } else {
                    sendRequestWithHttpURLConnection();
                }
        }

    }

    private ArrayList<City> getCity() {
        // where namecn = '长春'
        Cursor cursor = database.rawQuery("select * from city where id <= 12", null);
//        LogUtil.i(TAG, cursor + "\n");
        if (cursor != null) {
            int NUM_CITY = cursor.getCount();
            ArrayList<City> cities = new ArrayList<City>(NUM_CITY);
            if (cursor.moveToFirst()) {
                do {
                    int ID = cursor.getInt(cursor.getColumnIndex("ID"));
                    int AREAID = cursor.getInt(cursor.getColumnIndex("AREAID"));
                    String NAMEEN = cursor.getString(cursor.getColumnIndex("NAMEEN"));
                    String NAMECN = cursor.getString(cursor.getColumnIndex("NAMECN"));
                    String DISTRICTEN = cursor.getString(cursor.getColumnIndex("DISTRICTEN"));
                    String DISTRICTCN = cursor.getString(cursor.getColumnIndex("DISTRICTCN"));
                    String PROVEN = cursor.getString(cursor.getColumnIndex("PROVEN"));
                    String PROVCN = cursor.getString(cursor.getColumnIndex("PROVCN"));
                    String NATIONEN = cursor.getString(cursor.getColumnIndex("NATIONEN"));
                    String NATIONCN = cursor.getString(cursor.getColumnIndex("NATIONCN"));
                    City city = new City();
                    city.setID(ID);
                    city.setAREAID(AREAID);
                    city.setNAMECN(NAMECN);
                    city.setNAMEEN(NAMEEN);
                    city.setDISTRICTEN(DISTRICTEN);
                    city.setDISTRICTCN(DISTRICTCN);
                    city.setPROVEN(PROVEN);
                    city.setPROVCN(PROVCN);
                    city.setNATIONEN(NATIONEN);
                    city.setNATIONCN(NATIONCN);
                    cities.add(city);
                } while (cursor.moveToNext());
            }
            return cities;
        }
        return null;
    }
}
