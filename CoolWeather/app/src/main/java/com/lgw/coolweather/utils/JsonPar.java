package com.lgw.coolweather.utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by lgw on 2016-01-02.
 */
public class JsonPar {
    public static final String TAG = "JsonPar____________________";

    public static void parserJSONWithJSONObject(String data) {
        JSONArray js1, js2 = null;
        JSONObject obj1, obj2, obj4 = null;
        try {
            obj1 = new JSONObject(data);
            js1 = obj1.getJSONArray("HeWeather data service 3.0");
            for (int i = 0; i < obj1.length(); i++) {
                String test = js1.getString(i);
                JSONObject obj3 = new JSONObject(test);
                for (int n = 0; n < obj3.length(); n++) {
                    String hehe = obj3.getString("aqi");
                    obj4 = new JSONObject(hehe);
                }
                for (int m = 0; m < obj4.length(); m++) {
                    String hehehe = obj4.getString("city");
                    JSONObject obj5 = new JSONObject(hehehe);
                    String a = obj5.getString("aqi");
                    String b = obj5.getString("co");
                    String c = obj5.getString("no2");
                    String d = obj5.getString("o3");
                    String e = obj5.getString("pm10");
                    String f = obj5.getString("pm25");
                    String g = obj5.getString("qlty");
                    String h = obj5.getString("so2");
                    LogUtil.i(TAG, a + b + c + d + e + f + g + h + "");
                }
                obj2 = new JSONObject(test);
                js2 = obj2.getJSONArray("daily_forecast");
                for (int j = 0; j < obj2.length(); j++) {
                    String log = js2.getString(j);
                    //                    LogUtil.i(TAG, "" + log + "________+++++++++_________");
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
