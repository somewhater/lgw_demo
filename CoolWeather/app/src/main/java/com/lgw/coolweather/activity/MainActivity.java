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
import com.lgw.coolweather.httpclient.HttpConnectionTool;
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


public class MainActivity extends Activity implements View.OnClickListener {
    public String TAG = "MainActivity_____________________";
    public EditText city;
    public Button search;
    public TextView msg_tv;
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
                String response = new HttpConnectionTool().getResponse();
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
                    sendRequestWithHttpURLConnection();
                    Toast.makeText(getApplicationContext(), "输入的城市名称为空，请重新输入", Toast.LENGTH_SHORT).show();
                } else {
                    sendRequestWithHttpURLConnection();
                }
        }

    }
}
