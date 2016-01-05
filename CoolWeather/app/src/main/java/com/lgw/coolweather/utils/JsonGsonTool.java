package com.lgw.coolweather.utils;


import android.nfc.Tag;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lgw.coolweather.model.gson.Data;
import com.lgw.coolweather.model.gson.Weather;

import java.util.List;

/**
 * Created by lgw on 2016-01-03.
 */
public class JsonGsonTool {
    public static final String TAG = "JsonGsonTool____________________";

    public static void parserJSONWithGson(String mJsonData) {
        Gson gson = new Gson();
//        List<Data> mData = gson.fromJson(mJsonData, new TypeToken<List<Data>>() {
//        }.getType());
        Weather datas = gson.fromJson(mJsonData, Weather.class);
        LogUtil.i(TAG, datas.toString());
    }
}
