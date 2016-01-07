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
import com.lgw.coolweather.constant.Key;
import com.lgw.coolweather.db.DbHelper;
import com.lgw.coolweather.model.gson.Data;
import com.lgw.coolweather.utils.JsonGsonTool;
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
    public static final int SHOW_RESPONSE = 0;
    public String TAG = "MainActivity_____________________";
    private EditText city;
    private Button search;
    private TextView msg_tv;
    private HttpURLConnection con;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SHOW_RESPONSE:
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
                {
                    try {
                        URL url = new URL("https://api.heweather.com/x3/weather?cityid=" + City.BEIJING + "&key=" + Key.KEY);
                        LogUtil.i(TAG, url + "");
                        con = (HttpURLConnection) url.openConnection();
                        con.setRequestMethod("GET");
                        con.setConnectTimeout(8000);
                        con.setReadTimeout(8000);
                        int code = con.getResponseCode();
                        LogUtil.e(TAG, code + "++++++++++++++++++++");
                        InputStream ins = con.getInputStream();
                        BufferedReader reader = new BufferedReader(new InputStreamReader(ins));
                        StringBuilder response = new StringBuilder();
                        String line;
                        while ((line = reader.readLine()) != null) {
                            response.append(line);
                        }
                        //sonObjectTool.parserJSONWithJSONObject(response.toString());
                        Data[] data = JsonGsonTool.parserJSONWithGson(response.toString());
                        StringBuffer msg = new StringBuffer();
                        msg.append(data[0].getAqi().getCity().getAqi());
                        Message message = new Message();
                        message.what = SHOW_RESPONSE;
                        message.obj = response.toString();
                        handler.sendMessage(message);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        LogUtil.v(TAG, "当前网络错误请检查");
                        //                        e.printStackTrace();
                    } finally {
                        con.disconnect();
                    }
                }
            }
        }).start();
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.search:
                String cities = city.getText().toString();
                LogUtil.i(TAG, "" + cities);
                if (cities.equals("")) {
                    Toast.makeText(getApplicationContext(), "输入的城市名称为空，请重新输入", Toast.LENGTH_SHORT).show();
                } else {
                    sendRequestWithHttpURLConnection();
                    createDB();
                }
        }

    }

    private void createDB() {
        DbHelper mDbHelper = new DbHelper(this, "ChinaCities.db", null, 1);
        mDbHelper.getWritableDatabase();
    }
}
