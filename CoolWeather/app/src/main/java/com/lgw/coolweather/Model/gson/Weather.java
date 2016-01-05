package com.lgw.coolweather.model.gson;

import com.google.gson.annotations.SerializedName;
import com.lgw.coolweather.utils.LogUtil;

import java.io.Serializable;

/**
 * Created by Administrator on 2016-01-05.
 */
public class Weather implements Serializable {
    public static final String TAG = "Weather_________";
    @SerializedName("HeWeather data service 3.0")
    private Data[] datas;

    public Data[] getDatas() {
        return datas;
    }

    public void setDatas(Data[] datas) {
        this.datas = datas;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (Data data : datas) {
            stringBuffer.append(data);
        }
        return stringBuffer.toString();
    }
}
