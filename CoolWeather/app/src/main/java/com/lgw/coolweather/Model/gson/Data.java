package com.lgw.coolweather.model.gson;

import java.io.Serializable;

/**
 * Created by Administrator on 2016-01-05.
 */
public class Data implements Serializable {
    private Aqi aqi;
    private Basic basic;
    private Daily_forecast[] daily_forecasts;
    private Hourly_forecast[] hourly_forecast;
    private Now now;
    private String status;
    private Suggestion suggestion;

    public Aqi getAqi() {
        return aqi;
    }

    public void setAqi(Aqi aqi) {
        this.aqi = aqi;
    }

    public Basic getBasic() {
        return basic;
    }

    public void setBasic(Basic basic) {
        this.basic = basic;
    }

    public Daily_forecast[] getDaily_forecasts() {
        return daily_forecasts;
    }

    public void setDaily_forecasts(Daily_forecast[] daily_forecasts) {
        this.daily_forecasts = daily_forecasts;
    }

    public Hourly_forecast[] getHourly_forecast() {
        return hourly_forecast;
    }

    public void setHourly_forecast(Hourly_forecast[] hourly_forecast) {
        this.hourly_forecast = hourly_forecast;
    }

    public Now getNow() {
        return now;
    }

    public void setNow(Now now) {
        this.now = now;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Suggestion getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(Suggestion suggestion) {
        this.suggestion = suggestion;
    }
}
