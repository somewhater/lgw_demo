package com.lgw.coolweather.model.gson;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Administrator on 2016-01-05.
 */
public class Now implements Serializable {
    @SerializedName("cond")
    private Cond_now cond_now;
    private int fl;
    private int hum;
    private int pcpn;
    private int pres;
    private int temp;
    private int vis;
    private Wind wind;

    public Cond_now getCond_now() {
        return cond_now;
    }

    public void setCond_now(Cond_now cond_now) {
        this.cond_now = cond_now;
    }

    public int getFl() {
        return fl;
    }

    public void setFl(int fl) {
        this.fl = fl;
    }

    public int getHum() {
        return hum;
    }

    public void setHum(int hum) {
        this.hum = hum;
    }

    public int getPcpn() {
        return pcpn;
    }

    public void setPcpn(int pcpn) {
        this.pcpn = pcpn;
    }

    public int getPres() {
        return pres;
    }

    public void setPres(int pres) {
        this.pres = pres;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public int getVis() {
        return vis;
    }

    public void setVis(int vis) {
        this.vis = vis;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }
}
