package com.lgw.coolweather.utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by lgw on 2016-01-03.
 */
public class JsonGsonTool {
    public static final String TAG = "JsonGsonTool____________________";

    public static void parserJSONWithGson(String mJsonData) {
//        Gson gson = new Gson();
//        List<Object> mModel = gson.fromJson(mJsonData, new TypeToken<List<Object>>() {
//        }.getType());
//        LogUtil.i(TAG, mModel + "");
        String jsonData = null;
        try {
            jsonData = new JSONArray(new JSONObject(mJsonData).getString("HeWeather data service 3.0")).toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        LogUtil.i(TAG, jsonData);
    }
}
