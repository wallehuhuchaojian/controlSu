package com.walle.controlself.deffect;

import android.app.Application;

import com.example.greendaolib.DaoManager;

/**
 * Created by walle on 2017/7/28.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        try {
            DaoManager.initDao(this);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        DaoManager.getManager().colse();
    }
}
