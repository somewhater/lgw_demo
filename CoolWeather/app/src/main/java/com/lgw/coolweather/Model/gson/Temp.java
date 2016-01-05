package com.lgw.coolweather.model.gson;

import java.io.Serializable;

/**
 * Created by Administrator on 2016-01-05.
 */
public class Temp implements Serializable {
    private int max;
    private int min;

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }
}
