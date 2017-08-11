package com.walle.controlself.deffect.tools;

import java.util.Calendar;

/**
 * Created by walle on 2017/7/26.
 */

public class TimeTools {
    public static  int getCurrentHour(){
        long time=System.currentTimeMillis();
        Calendar mCalendar=Calendar.getInstance();
        mCalendar.setTimeInMillis(time);
        int mHour=mCalendar.get(Calendar.HOUR);
        return mHour;
    }
    public static long getTodayLeft(){
        Calendar cal   =   Calendar.getInstance();
        cal.add(Calendar.DATE,  1);
        return cal.getTime().getTime()-System.currentTimeMillis();
    }
}
