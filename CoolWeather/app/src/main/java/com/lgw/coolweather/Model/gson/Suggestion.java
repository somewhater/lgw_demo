package com.lgw.coolweather.model.gson;

import java.io.Serializable;

/**
 * Created by Administrator on 2016-01-05.
 */
public class Suggestion implements Serializable {
    private Comf comf;
    private Cw cw;
    private Drsg drsg;
    private Flu flu;
    private Sport sport;
    private Trav trav;
    private Uv uv;

    public Comf getComf() {
        return comf;
    }

    public void setComf(Comf comf) {
        this.comf = comf;
    }

    public Cw getCw() {
        return cw;
    }

    public void setCw(Cw cw) {
        this.cw = cw;
    }

    public Drsg getDrsg() {
        return drsg;
    }

    public void setDrsg(Drsg drsg) {
        this.drsg = drsg;
    }

    public Flu getFlu() {
        return flu;
    }

    public void setFlu(Flu flu) {
        this.flu = flu;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public Trav getTrav() {
        return trav;
    }

    public void setTrav(Trav trav) {
        this.trav = trav;
    }

    public Uv getUv() {
        return uv;
    }

    public void setUv(Uv uv) {
        this.uv = uv;
    }
}
