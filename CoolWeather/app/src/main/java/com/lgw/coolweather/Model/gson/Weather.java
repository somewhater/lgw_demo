package com.lgw.coolweather.model.gson;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Administrator on 2016-01-05.
 */
public class Weather implements Serializable {
    @SerializedName("HeWeather data service 3.0")
    private Data[] datas;

    public Data[] getDatas() {
        return datas;
    }

    public void setDatas(Data[] datas) {
        this.datas = datas;
    }
}
