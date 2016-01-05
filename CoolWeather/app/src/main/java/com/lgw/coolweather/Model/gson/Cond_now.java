package com.lgw.coolweather.model.gson;


import java.io.Serializable;

/**
 * Created by Administrator on 2016-01-05.
 */
public class Cond_now implements Serializable {
    private int code;
    private String txt;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }
}
