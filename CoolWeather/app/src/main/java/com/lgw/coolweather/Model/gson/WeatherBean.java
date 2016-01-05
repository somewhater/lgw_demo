package com.lgw.coolweather.model.gson;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Administrator on 2016-01-05.
 */
public class WeatherBean implements Serializable {
    @SerializedName("HeWeather data service 3.0")
    private String jsonname;

    public String getJsonname() {
        return jsonname;
    }

    public void setJsonname(String jsonname) {
        this.jsonname = jsonname;
    }
}
