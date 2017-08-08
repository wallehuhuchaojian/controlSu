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
    private Long id;
    @NotNull
    private String doWhat;//what thing to do
    private String doWanna;// the result wanna to get
   private String type;
    private int attributive; //which plan it attributive to
    private int color=0xffffffff;// the color flag ,it default is plan's color with alpha ,if it is a freedom event the color will be random and can be customize

}
