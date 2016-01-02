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
        JSONObject js1, js2 = null;
        JSONArray obj1, obj2 = null;
        try {
            js1 = new JSONObject(data);
            obj1 = js1.getJSONArray("HeWeather data service 3.0");
            for (int i = 0; i < js1.length(); i++) {
                String test = obj1.getString(i);
                //                LogUtil.i(TAG, "" + test + "________+++++++++_________");
                js2 = new JSONObject(test);
                obj2 = js2.getJSONArray("daily_forecast");
                for (int j = 0; j < js2.length(); j++) {
                    String log = obj2.getString(j);
                    LogUtil.i(TAG, "" + log + "________+++++++++_________");
                }
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
