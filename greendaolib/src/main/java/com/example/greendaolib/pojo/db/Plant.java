package com.example.greendaolib.pojo.db;

import android.support.annotation.Keep;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by walle on 2017/8/10.
 */
@Entity
public class Plant {
    @Id(autoincrement = true)
    Long id;
    @NotNull
    Long beLongsId;
    @NotNull
    private    String name;
    @Transient
    PlanInfo info;
    @Transient
    PlanStatus status;
    @Transient
    PlanSummary summary;
    private long summaryId;

    private long statusId;

    public PlanInfo getInfo() {
        return info;
    }

    public void setInfo(PlanInfo info) {
        this.info = info;
    }

    public PlanStatus getStatus() {
        return status;
    }

    public void setStatus(PlanStatus status) {
        this.status = status;
    }

    public PlanSummary getSummary() {
        return summary;
    }

    public void setSummary(PlanSummary summary) {
        this.summary = summary;
    }

    public long getStatusId() {
        return this.statusId;
    }
    public void setStatusId(long statusId) {
        this.statusId = statusId;
    }
   
    public long getSummaryId() {
        return this.summaryId;
    }
    public void setSummaryId(long summaryId) {
        this.summaryId = summaryId;
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
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Generated(hash = 914464644)
    public Plant(Long id, @NotNull Long beLongsId, @NotNull String name, long summaryId, long statusId) {
        this.id = id;
        this.beLongsId = beLongsId;
        this.name = name;
        this.summaryId = summaryId;
        this.statusId = statusId;
    }
    @Generated(hash = 878011190)
    public Plant() {
    }

    @Override
    public String toString() {
        return "Plant{" +
                "id=" + id +
                ", beLongsId=" + beLongsId +
                ", name='" + name + '\'' +
                ", info=" + info +
                ", status=" + status +
                ", summary=" + summary +
                ", summaryId=" + summaryId +
                ", statusId=" + statusId +
                '}';
    }
}
