package com.lgw.coolweather.httpclient;

import com.lgw.coolweather.utils.LogUtil;

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

    public static String getResponse(String cityID, String key) {
        String rep = "";
        try {
            URL url = new URL("https://api.heweather.com/x3/weather?cityid=" + key + "&key=" + cityID);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("get");
            con.setConnectTimeout(8000);
            con.setReadTimeout(8000);
            int requestCode = con.getResponseCode();
            LogUtil.i(TAG, "返回码为：" + requestCode);
            String requestMessage = con.getResponseMessage();
            LogUtil.i(TAG, "requestMessage is ___+++___" + requestMessage);
            InputStream ins = con.getInputStream();
            InputStreamReader insReader = new InputStreamReader(ins);
            BufferedReader bfReader = new BufferedReader(insReader);
            StringBuilder str = new StringBuilder();
            String line = bfReader.readLine();
            while (line != null) {
                str.append(line + "\n");
            }
            rep = str.toString();
        } catch (MalformedURLException e) {
            //e.printStackTrace();
            LogUtil.e(TAG, "URL not found");
        } catch (IOException e) {
            //e.printStackTrace();
            LogUtil.e(TAG, "当前网络无网络");
        }
        return rep;
    }
}
