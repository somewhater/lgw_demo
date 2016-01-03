package com.lgw.coolweather.utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by lgw on 2016-01-02.
 */
public class JsonObjectTool {
    public static final String TAG = "JsonObjectTool____________________";

    public static void parserJSONWithJSONObject(String data) {
        JSONArray js1, js2 = null;
        JSONObject obj1, obj2, obj5 = null;
        try {
            obj1 = new JSONObject(data);
            js1 = obj1.getJSONArray("HeWeather data service 3.0");
            for (int i = 0; i < obj1.length(); i++) {
                String test = js1.getString(i);

                obj5 = new JSONObject(new JSONObject(new JSONObject(test).getString("aqi")).getString("city"));
                String a = obj5.getString("aqi");
                String b = obj5.getString("co");
                String c = obj5.getString("no2");
                String d = obj5.getString("o3");
                String e = obj5.getString("pm10");
                String f = obj5.getString("pm25");
                String g = obj5.getString("qlty");
                String h = obj5.getString("so2");
                LogUtil.i(TAG, a + b + c + d + e + f + g + h + "");

                obj2 = new JSONObject(test);
                js2 = obj2.getJSONArray("daily_forecast");
                for (int j = 0; j < obj2.length(); j++) {
                    String log = js2.getString(j);
                    LogUtil.i(TAG, "" + log + "________+++++++++_________");
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
