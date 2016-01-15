package com.lgw.coolweather.httpclient;

import android.os.Message;

import com.lgw.coolweather.constant.City;
import com.lgw.coolweather.constant.MainMessage;
import com.lgw.coolweather.constant.RequestData;
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

/**
 * Created by Administrator on 2016-01-10.
 */
public class HttpConnectionTool {
    public static final String TAG = "HttpConnectionTool_________";
    private HttpURLConnection con;
    private URL url = null;
    private StringBuilder response;

    public String getResponse() {

        try {
            url = new URL("https://api.heweather.com/x3/weather?cityid=" + City.GUANGZHOU + "&key=" + RequestData.KEY);
            LogUtil.i(TAG, url + "");
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setConnectTimeout(8000);
            con.setReadTimeout(8000);
            int code = con.getResponseCode();
            LogUtil.e(TAG, code + "++++++++++++++++++++");
            InputStream ins = con.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(ins));
            response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
//            Message message = new Message();
//            message.what = MainMessage.SHOW_RESPONSE;
//            message.obj = response.toString();
//            JsonObjectTool.parserJSONWithJSONObject(response.toString());
//            new JSONArray();
//            hander.sendMessage(message);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            LogUtil.v(TAG, "当前网络错误请检查");
            //e.printStackTrace();
        } finally {
            con.disconnect();
        }
        return response.toString();
    }
}
