package com.walle.controlself.deffect.pojo;

/**
 * Created by walle on 2017/7/26.
 */

public class EventsInfo {
    private String name;
    private int color=0xffffffff;
    private String discrib;
    private String[] item;
    private int[] hours;

    public int[] getHours() {
        return hours;
    }

    public void setHours(int[] hours) {
        this.hours = hours;
    }

    public EventsInfo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getDiscrib() {
        return discrib;
    }

    public void setDiscrib(String discrib) {
        this.discrib = discrib;
    }

    public String[] getItem() {
        return item;
    }

    public void setItem(String[] item) {
        this.item = item;
    }

    public EventsInfo(String name, int color, String discrib, String[] item) {
        this.name = name;
        this.color = color;
        this.discrib = discrib;
        this.item = item;
    }
}
