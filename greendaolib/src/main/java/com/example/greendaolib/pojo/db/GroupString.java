package com.example.greendaolib.pojo.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by walle on 2017/8/10.
 */
@Entity
public class GroupString {
    private String type;
    @Id(autoincrement = true)
    private Long id;
    @NotNull
    private String str;
    private int index;
    @NotNull
    private Long belongsId;
    public Long getBelongsId() {
        return this.belongsId;
    }
    public void setBelongsId(Long belongsId) {
        this.belongsId = belongsId;
    }
    public int getIndex() {
        return this.index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
    public String getStr() {
        return this.str;
    }
    public void setStr(String str) {
        this.str = str;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getType() {
        return this.type;
    }
    public void setType(String type) {
        this.type = type;
    }
    @Generated(hash = 891183308)
    public GroupString(String type, Long id, @NotNull String str, int index,
            @NotNull Long belongsId) {
        this.type = type;
        this.id = id;
        this.str = str;
        this.index = index;
        this.belongsId = belongsId;
    }
    @Generated(hash = 110545626)
    public GroupString() {
    }
}
