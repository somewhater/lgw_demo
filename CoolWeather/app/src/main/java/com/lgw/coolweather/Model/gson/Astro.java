package com.lgw.coolweather.model.gson;

import java.io.Serializable;

/**
 * Created by Administrator on 2016-01-05.
 */
public class Astro implements Serializable {
    private String sr;
    private String ss;

    public String getSr() {
        return sr;
    }

    public void setSr(String sr) {
        this.sr = sr;
    }

    public String getSs() {
        return ss;
    }

    public void setSs(String ss) {
        this.ss = ss;
    }
}
