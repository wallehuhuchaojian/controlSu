package com.example.greendaolib.pojo.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;

/**
 * Created by walle on 2017/7/28.
 */
@Entity
public class WeekPlan {
    @Id(autoincrement = true)
    private  long id;
    @NotNull
    private String doWhat;//what thing to do
    private String doWanna;// the result wanna to get
    private int attributive; //which plan it attributive to
    private int color=0xffffffff;
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
    @Generated(hash = 1319619532)
    public WeekPlan(long id, @NotNull String doWhat, String doWanna,
            int attributive, int color) {
        this.id = id;
        this.doWhat = doWhat;
        this.doWanna = doWanna;
        this.attributive = attributive;
        this.color = color;
    }
    @Generated(hash = 1036051451)
    public WeekPlan() {
    }

}
