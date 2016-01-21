package com.lgw.coolweather.activity;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.lgw.coolweather.R;
import com.lgw.coolweather.constant.MainMessage;
import com.lgw.coolweather.db.DBManager;
import com.lgw.coolweather.model.city.City;

import java.util.ArrayList;


public class MainActivity extends Activity implements View.OnClickListener {
    public String TAG = "MainActivity_____________________";
    public TextView search;
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

        DBManager dbManager = new DBManager(this);
        dbManager.openDatabase();
        dbManager.closeDatabase();
        search = (TextView) findViewById(R.id.search);
        msg_tv = (TextView) findViewById(R.id.msg);
        search.setOnClickListener(this);
    }

    private void sendRequestWithHttpURLConnection() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                database = SQLiteDatabase.openOrCreateDatabase(DBManager.DB_PATH + "/" + DBManager.DB_NAME, null);
                String response = null;
                cities = getCity();
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
                sendRequestWithHttpURLConnection();
                break;
        }
    }


    private ArrayList<City> getCity() {
        Cursor cursor = database.rawQuery("select * from city where id = 12", null);
        if (cursor != null) {
            int NUM_CITY = cursor.getCount();
            ArrayList<City> cities = new ArrayList<>(NUM_CITY);
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
                cursor.close();
            }
            return cities;
        }
        return null;
    }
}
