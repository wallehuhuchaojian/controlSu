package com.example.greendaolib;

import android.app.Application;
import android.content.Context;

import com.example.greendaolib.dao.DaoMaster;
import com.example.greendaolib.dao.DaoSession;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.database.Database;

/**
 * Created by walle on 2017/7/28.
 */

public class DaoManager {
    private static DaoManager manager;
    public static final  String dbName="controlSelfdb";
    private DaoSession daoSession;



    public DaoManager(Context context) {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, dbName);
        Database db = helper.getWritableDb();
        daoSession=new DaoMaster(db).newSession();

    }
    public static void initDao(Context context) throws Exception {
        if (manager!=null){
            throw new DaoException("DaoManager has been init");
        }else {
            manager=new DaoManager(context);
        }
    }

    public static DaoManager getManager() {
        return manager;
    }
    public <T>  AbstractDao getDao(Class cl){
        AbstractDao dao=  daoSession.getDao(cl);
        return dao;
    }
    public void  colse(){
        daoSession.getDatabase().close();

    }

}
