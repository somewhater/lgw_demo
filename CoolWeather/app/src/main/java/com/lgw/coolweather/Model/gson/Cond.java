package com.lgw.coolweather.model.gson;

import java.io.Serializable;

/**
 * Created by Administrator on 2016-01-05.
 */
public class Cond implements Serializable {
    private int code_d;
    private int code_n;
    private String txt_d;
    private String txt_n;

    public int getCode_d() {
        return code_d;
    }

    public void setCode_d(int code_d) {
        this.code_d = code_d;
    }

    public int getCode_n() {
        return code_n;
    }

    public void setCode_n(int code_n) {
        this.code_n = code_n;
    }

    public String getTxt_d() {
        return txt_d;
    }

    public void setTxt_d(String txt_d) {
        this.txt_d = txt_d;
    }

    public String getTxt_n() {
        return txt_n;
    }

    public void setTxt_n(String txt_n) {
        this.txt_n = txt_n;
    }
}
