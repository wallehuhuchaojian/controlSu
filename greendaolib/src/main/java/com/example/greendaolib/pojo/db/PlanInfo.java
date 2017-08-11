package com.example.greendaolib.pojo.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Transient;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by walle on 2017/8/10.
 */

public class PlanInfo {
   private List<String> step;
   private List<String> target,disturbance,reason;

   public List<String> getStep() {
      return step;
   }

   public void setStep(List<String> step) {
      this.step = step;
   }

   public List<String> getTarget() {
      return target;
   }

   public void setTarget(List<String> target) {
      this.target = target;
   }

   public List<String> getDisturbance() {
      return disturbance;
   }

   public void setDisturbance(List<String> disturbance) {
      this.disturbance = disturbance;
   }

   public List<String> getReason() {
      return reason;
   }

   public void setReason(List<String> reason) {
      this.reason = reason;
   }

   @Override
   public String toString() {
      return "PlanInfo{" +
              "step=" + step +
              ", target=" + target +
              ", disturbance=" + disturbance +
              ", reason=" + reason +
              '}';
   }
}
