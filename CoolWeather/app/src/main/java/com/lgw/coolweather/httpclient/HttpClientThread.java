package com.lgw.coolweather.httpclient;

import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import com.lgw.coolweather.constant.City;
import com.lgw.coolweather.constant.MainMessage;
import com.lgw.coolweather.constant.RequestData;
import com.lgw.coolweather.model.gson.Data;
import com.lgw.coolweather.utils.JsonGsonTool;
import com.lgw.coolweather.utils.LogUtil;
import com.lgw.coolweather.utils.MainHandler;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrator on 2016-01-08.
 */
public class HttpClientThread implements Runnable {
    public final String TAG = "HttpClientThread_________";
    private HttpURLConnection con;
    private StringBuffer msg;
    private Message message;

    private String key;
    private String cityID;
    private MainHandler handler;
    private TextView mTextView;

    public HttpClientThread(MainHandler handler, String key, String cityID, TextView mTextView) {
        this.key = key;
        this.cityID = cityID;
        this.handler = handler;
        this.mTextView = mTextView;
    }

    @Override
    public void run() {
        try {

            URL url = new URL("https://api.heweather.com/x3/weather?cityid=" + key + "&key=" + cityID);
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
            //JEONObject请求
            // sonObjectTool.parserJSONWithJSONObject(response.toString());
            Data[] data = JsonGsonTool.parserJSONWithGson(response.toString());
            msg = new StringBuffer();
            msg.append(data[0].getAqi().getCity().getAqi());
            message = new Message();
            message.what = MainMessage.SHOW_RESPONSE;
            message.obj = response.toString();
            handler.sendMessage(message);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            LogUtil.v(TAG, "当前网络错误请检查");
            //e.printStackTrace();
        } finally {
            con.disconnect();
        }
    }
}
