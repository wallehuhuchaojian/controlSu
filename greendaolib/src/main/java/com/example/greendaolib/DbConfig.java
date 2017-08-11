package com.example.greendaolib;

/**
 * Created by walle on 2017/8/10.
 */

public class DbConfig {
   public interface PLANSTATUS{

        String planing="planing";
        String doing="doing";
        String outTime="outTime";
        String cancel="cancel";
        String undone="undone";
        String complete="complete";
        String imComplete="imComplete";
    }
    public interface STRINGTYPE{

        String summary="summary";
        String target="target";
        String step="step";
        String disturbance="disturbance";
        String reason="reason";
    }
}
