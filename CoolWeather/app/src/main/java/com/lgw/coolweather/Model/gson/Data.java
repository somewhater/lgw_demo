package com.lgw.coolweather.model.gson;

import java.io.Serializable;

/**
 * Created by Administrator on 2016-01-05.
 */
public class Data implements Serializable {
    private Aqi aqi;
    private Basic basic;
    private Daily_forecast[] daily_forecasts;

}
