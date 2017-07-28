package com.walle.controlself.deffect;

/**
 * Created by walle on 2017/7/27.
 */

public class Config {
    public static int width,height;
    public static int devider=width/50;
    public interface PlanStatus{
        int planing=1;
        int doing=2;
        int checking=3;
        int adjusting=4;
    }

}
