package com.zsk.bean;

public class Date {
    private String area;
    private Integer nowConfirm;
    private Integer confirm;
    private Integer heal;
    private Integer dead;

    public Date() {
    }

    public Date(String area, Integer nowConfirm, Integer confirm, Integer heal, Integer dead) {
        this.area = area;
        this.nowConfirm = nowConfirm;
        this.confirm = confirm;
        this.heal = heal;
        this.dead = dead;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Integer getNowConfirm() {
        return nowConfirm;
    }

    public void setNowConfirm(Integer nowConfirm) {
        this.nowConfirm = nowConfirm;
    }

    public Integer getConfirm() {
        return confirm;
    }

    public void setConfirm(Integer confirm) {
        this.confirm = confirm;
    }

    public Integer getHeal() {
        return heal;
    }

    public void setHeal(Integer heal) {
        this.heal = heal;
    }

    public Integer getDead() {
        return dead;
    }

    public void setDead(Integer dead) {
        this.dead = dead;
    }
}
