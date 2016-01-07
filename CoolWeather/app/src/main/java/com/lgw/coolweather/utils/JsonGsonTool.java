package com.lgw.coolweather.utils;

import com.google.gson.Gson;
import com.lgw.coolweather.model.gson.Basic;
import com.lgw.coolweather.model.gson.City;
import com.lgw.coolweather.model.gson.Daily_forecast;
import com.lgw.coolweather.model.gson.Data;
import com.lgw.coolweather.model.gson.Hourly_forecast;
import com.lgw.coolweather.model.gson.Now;
import com.lgw.coolweather.model.gson.Suggestion;
import com.lgw.coolweather.model.gson.Weather;


/**
 * Created by lgw on 2016-01-03.
 */
public class JsonGsonTool {
    public static final String TAG = "JsonGsonTool____________________";

    public static Data[] parserJSONWithGson(String mJsonData) {
        Gson gson = new Gson();
        Weather weather = gson.fromJson(mJsonData, Weather.class);
        Data[] data = weather.getDatas();
        City city = data[0].getAqi().getCity();
        int aqi = city.getAqi();
        int co = city.getCo();
        int no2 = city.getNo2();
        int o3 = city.getO3();
        int pm10 = city.getPm10();
        int pm25 = city.getPm25();
        String qlty = city.getQlty();
        int so2 = city.getSo2();
        LogUtil.i(TAG, aqi + "-" + co + "-" + no2 + "-" + o3 + "-" + pm10 + "-" + pm25 + "-" + qlty + "-" + so2);
        Daily_forecast[] daily_forecasts = data[0].getDaily_forecast();
        LogUtil.i(TAG, daily_forecasts.length + "");
        for (Daily_forecast daily_forecast : daily_forecasts) {
            daily_forecast.getAstro();
            daily_forecast.getCond();
            daily_forecast.getDate();
            daily_forecast.getHum();
            daily_forecast.getPcpn();
            daily_forecast.getPop();
            daily_forecast.getPres();
            daily_forecast.getTemp();
            daily_forecast.getVis();
            daily_forecast.getWind();
            LogUtil.i(TAG, daily_forecast.toString());
        }
        Basic basic = data[0].getBasic();
        Hourly_forecast[] hourly_forecast = data[0].getHourly_forecast();
        Now now = data[0].getNow();
        String state = data[0].getStatus();
        Suggestion suggestion = data[0].getSuggestion();
        return data;
    }
}
