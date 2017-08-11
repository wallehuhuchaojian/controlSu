package com.example.greendaolib.pojo.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by walle on 2017/8/10.
 */
@Entity
public class PlanStatus {
    @Id(autoincrement = true)
    private Long id;
    @NotNull
    private Long belongsId;
    @NotNull
    private boolean isColse=false;
    @NotNull
    private Long creatTime=System.currentTimeMillis(),startTime,keepTime;
    private Long  closeTime,summaryTime,lastUpDateTime;
    @NotNull
    private String state;
    public String getState() {
        return this.state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public Long getLastUpDateTime() {
        return this.lastUpDateTime;
    }
    public void setLastUpDateTime(Long lastUpDateTime) {
        this.lastUpDateTime = lastUpDateTime;
    }
    public Long getSummaryTime() {
        return this.summaryTime;
    }
    public void setSummaryTime(Long summaryTime) {
        this.summaryTime = summaryTime;
    }
    public Long getCloseTime() {
        return this.closeTime;
    }
    public void setCloseTime(Long closeTime) {
        this.closeTime = closeTime;
    }
    public Long getKeepTime() {
        return this.keepTime;
    }
    public void setKeepTime(Long keepTime) {
        this.keepTime = keepTime;
    }
    public Long getStartTime() {
        return this.startTime;
    }
    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }
    public Long getCreatTime() {
        return this.creatTime;
    }
    public void setCreatTime(Long creatTime) {
        this.creatTime = creatTime;
    }
    public boolean getIsColse() {
        return this.isColse;
    }
    public void setIsColse(boolean isColse) {
        this.isColse = isColse;
    }
    public Long getBelongsId() {
        return this.belongsId;
    }
    public void setBelongsId(Long belongsId) {
        this.belongsId = belongsId;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Generated(hash = 1277809428)
    public PlanStatus(Long id, @NotNull Long belongsId, boolean isColse,
            @NotNull Long creatTime, @NotNull Long startTime,
            @NotNull Long keepTime, Long closeTime, Long summaryTime,
            Long lastUpDateTime, @NotNull String state) {
        this.id = id;
        this.belongsId = belongsId;
        this.isColse = isColse;
        this.creatTime = creatTime;
        this.startTime = startTime;
        this.keepTime = keepTime;
        this.closeTime = closeTime;
        this.summaryTime = summaryTime;
        this.lastUpDateTime = lastUpDateTime;
        this.state = state;
    }
    @Generated(hash = 2037492113)
    public PlanStatus() {
    }

    @Override
    public String toString() {
        return "PlanStatus{" +
                "id=" + id +
                ", belongsId=" + belongsId +
                ", isColse=" + isColse +
                ", creatTime=" + creatTime +
                ", startTime=" + startTime +
                ", keepTime=" + keepTime +
                ", closeTime=" + closeTime +
                ", summaryTime=" + summaryTime +
                ", lastUpDateTime=" + lastUpDateTime +
                ", state='" + state + '\'' +
                '}';
    }
}
