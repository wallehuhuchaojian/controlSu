package com.walle.controlself.deffect;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.example.greendaolib.DaoManager;
import com.example.greendaolib.DbConfig;
import com.example.greendaolib.dao.PlantDao;
import com.example.greendaolib.pojo.db.PlanInfo;
import com.example.greendaolib.pojo.db.PlanStatus;
import com.example.greendaolib.pojo.db.Plant;
import com.walle.controlself.deffect.data.PlanCommander;
import com.walle.controlself.deffect.tools.TimeTools;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    String TAG="ExampleInstrumentedTest";
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        PlantDao dao= (PlantDao) DaoManager.getManager().getDao(Plant.class);
        Log.i(TAG,"你说你");

        PlanCommander commander=new PlanCommander();
        Plant plant=new Plant();
        plant.setBeLongsId(-1L);
        plant.setName("testPlan");
        PlanInfo planInfo=new PlanInfo();
        List<String> target=new ArrayList<>();
        target.add("impove Executive power");
        target.add("try a chance");
        target.add("say a finish");
        planInfo.setTarget(target);
        List<String> reason=new ArrayList<>();
        reason.add("time is enough");
        reason.add("think it for a long time");
        reason.add("think overcome my Disadvantages");
        planInfo.setReason(reason);
        List<String> step=new ArrayList<>();
        step.add("befor next week finish the function version");
        step.add("this month arrived to get app that can useage");
        planInfo.setStep(step);
        PlanStatus status=new PlanStatus();
        status.setKeepTime(TimeTools.getTodayLeft());
        status.setIsColse(false);
        status.setStartTime(System.currentTimeMillis());
        status.setLastUpDateTime(System.currentTimeMillis());
        status.setState(DbConfig.PLANSTATUS.planing);

        commander.createNewOne(plant,status,planInfo);

        List<Plant> plants=dao.loadAll();
        System.out.print(plants.toString());
        assertEquals("com.walle.controlself.deffect", appContext.getPackageName());
    }
    @Test
    public void getAllPlant(){

        PlanCommander commander=new PlanCommander();
        commander.getAllPlant();
    }
}
