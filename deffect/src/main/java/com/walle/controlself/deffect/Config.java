package com.walle.controlself.deffect;

/**
 * Created by walle on 2017/7/27.
 */

public class Config {
    public static int width,height;
    public static int devider=width/50;
    public interface  TAGSTYPE{
        int step=1;

        int target=2;
        int disturbance=3;
        int reason=4;
        int summary=5;
        int littleTags=6;

    }
//    public interface PlanStatus{
//        int planing=1;
//        int doing=2;
//        int checking=3;
//        int adjusting=4;
//    }
//    public interface PlanType{
//        int events=1;//events
//        int week=2;
//        int month=3;
//        int season=4;
//    }

}
