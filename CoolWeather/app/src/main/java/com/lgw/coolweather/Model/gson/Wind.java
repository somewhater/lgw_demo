package com.lgw.coolweather.model.gson;

import java.io.Serializable;

/**
 * Created by Administrator on 2016-01-05.
 */
public class Wind implements Serializable {
    private int deg;
    private String dir;
    private String sc;
    private int spd;

    public int getDeg() {
        return deg;
    }

    public void setDeg(int deg) {
        this.deg = deg;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getSc() {
        return sc;
    }

    public void setSc(String sc) {
        this.sc = sc;
    }

    public int getSpd() {
        return spd;
    }

    public void setSpd(int spd) {
        this.spd = spd;
    }
}
