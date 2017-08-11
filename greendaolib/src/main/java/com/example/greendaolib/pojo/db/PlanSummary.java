package com.example.greendaolib.pojo.db;

import android.support.annotation.Keep;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Transient;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by walle on 2017/8/10.
 */
@Entity
public class PlanSummary {
    @Id(autoincrement = true)
    Long id;
    @NotNull
    Long beLongsId;
    private float rate;
    private String evaluation;
    @Transient
    List<GroupString> summarys;
    @Transient
    List<GroupString> improves;
    public String getEvaluation() {
        return this.evaluation;
    }
    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }
    public float getRate() {
        return this.rate;
    }
    public void setRate(float rate) {
        this.rate = rate;
    }
    public Long getBeLongsId() {
        return this.beLongsId;
    }
    public void setBeLongsId(Long beLongsId) {
        this.beLongsId = beLongsId;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Generated(hash = 1517689929)
    public PlanSummary(Long id, @NotNull Long beLongsId, float rate,
            String evaluation) {
        this.id = id;
        this.beLongsId = beLongsId;
        this.rate = rate;
        this.evaluation = evaluation;
    }
    @Generated(hash = 1803916172)
    public PlanSummary() {
    }
}
