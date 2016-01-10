package com.lgw.coolweather.activity;

import android.app.Activity;
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
import com.lgw.coolweather.constant.City;
import com.lgw.coolweather.constant.MainMessage;
import com.lgw.coolweather.constant.RequestData;
import com.lgw.coolweather.db.DbHelper;
import com.lgw.coolweather.httpclient.HttpClientThread;
import com.lgw.coolweather.httpclient.HttpConnectionTool;
import com.lgw.coolweather.utils.JsonGsonTool;
import com.lgw.coolweather.utils.LogUtil;
import com.lgw.coolweather.utils.MainHandler;


public class MainActivity extends Activity implements View.OnClickListener {
    public String TAG = "MainActivity_____________________";
    private EditText city;
    private Button search;
    private TextView msg_tv;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MainMessage.SHOW_RESPONSE:
                    msg_tv.setText((String) msg.obj);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.search:
                String cities = city.getText().toString();
                LogUtil.i(TAG, "" + cities);
                if (cities.equals("")) {
                    Toast.makeText(getApplicationContext(), "输入的城市名称为空，请重新输入", Toast.LENGTH_SHORT).show();
                } else {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            String request = HttpConnectionTool.getResponse(City.GUANGZHOU, RequestData.KEY);
                            Message msg = new Message();
                            msg.what = MainMessage.SHOW_RESPONSE;
                            msg.obj = request;
                        }
                    }).start();
                }
        }

    }

    private void createDB() {
        DbHelper mDbHelper = new DbHelper(this, "ChinaCities.db", null, 1);
        mDbHelper.getWritableDatabase();
    }
}
