package com.example.greendaolib.pojo.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;

/**
 * Created by walle on 2017/7/26.
 */
@Entity
public class EventsInfo {
    int status;//the status of events one of plan do check summarize;
    @Id(autoincrement = true)
    private long id;
    @NotNull
    private String doWhat;//what thing to do
    private String doWanna;// the result wanna to get
    private String  hours;//time‘s string gap by "," like 8,9,10
    private int attributive; //which plan it attributive to
    private int color=0xffffffff;// the color flag ,it default is plan's color with alpha ,if it is a freedom event the color will be random and can be customize
    public int getColor() {
        return this.color;
    }
    public void setColor(int color) {
        this.color = color;
    }
    public int getAttributive() {
        return this.attributive;
    }
    public void setAttributive(int attributive) {
        this.attributive = attributive;
    }
    public String getHours() {
        return this.hours;
    }
    public void setHours(String hours) {
        this.hours = hours;
    }
    public String getDoWanna() {
        return this.doWanna;
    }
    public void setDoWanna(String doWanna) {
        this.doWanna = doWanna;
    }
    public String getDoWhat() {
        return this.doWhat;
    }
    public void setDoWhat(String doWhat) {
        this.doWhat = doWhat;
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public int getStatus() {
        return this.status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    @Generated(hash = 1926091581)
    public EventsInfo(int status, long id, @NotNull String doWhat, String doWanna, String hours, int attributive, int color) {
        this.status = status;
        this.id = id;
        this.doWhat = doWhat;
        this.doWanna = doWanna;
        this.hours = hours;
        this.attributive = attributive;
        this.color = color;
    }
    @Generated(hash = 1146244956)
    public EventsInfo() {
    }
}
