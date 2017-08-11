package com.walle.controlself.deffect.data;

import android.util.Log;

import com.example.greendaolib.DaoManager;
import com.example.greendaolib.DbConfig;
import com.example.greendaolib.dao.GroupStringDao;
import com.example.greendaolib.dao.PlanStatusDao;
import com.example.greendaolib.dao.PlantDao;
import com.example.greendaolib.pojo.db.GroupString;
import com.example.greendaolib.pojo.db.PlanInfo;
import com.example.greendaolib.pojo.db.PlanStatus;
import com.example.greendaolib.pojo.db.Plant;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by walle on 2017/8/11.
 */

public class PlanCommander {
    public  static void createNewOne(Plant plant,PlanStatus status, PlanInfo info){
       PlantDao plantDao= (PlantDao) DaoManager.getManager().getDao(Plant.class);
        PlanStatusDao statusDao= (PlanStatusDao) DaoManager.getManager().getDao(PlanStatus.class);
         GroupStringDao stringDao= (GroupStringDao) DaoManager.getManager().getDao(GroupString.class);
        plantDao.deleteAll();
        statusDao.deleteAll();
        statusDao.deleteAll();
        long id=plantDao.insertOrReplace(plant);
        status.setBelongsId(id);
        long statusId=statusDao.insert(status);
        plant.setStatusId(statusId);

     if (info.getTarget()!=null&&info.getTarget().size()!=0){
            for (int i = 0; i < info.getTarget().size(); i++) {
             saveStringGroup(stringDao,id,i, DbConfig.STRINGTYPE.target,info.getTarget().get(i));
             }
      }
     if (info.getStep()!=null&&info.getStep().size()!=0){
            for (int i = 0; i < info.getStep().size(); i++) {
             saveStringGroup(stringDao,id,i, DbConfig.STRINGTYPE.step,info.getStep().get(i));
             }
      }
     if (info.getReason()!=null&&info.getReason().size()!=0){
            for (int i = 0; i < info.getReason().size(); i++) {
             saveStringGroup(stringDao,id,i, DbConfig.STRINGTYPE.reason,info.getReason().get(i));
             }
      }
     if (info.getDisturbance()!=null&&info.getDisturbance().size()!=0){
            for (int i = 0; i < info.getDisturbance().size(); i++) {
             saveStringGroup(stringDao,id,i, DbConfig.STRINGTYPE.disturbance,info.getDisturbance().get(i));
             }
      }

     plantDao.update(plant);

     }
    public static List<Plant> getAllPlant(){
        PlantDao plantDao= (PlantDao) DaoManager.getManager().getDao(Plant.class);
        GroupStringDao stringDao= (GroupStringDao) DaoManager.getManager().getDao(GroupString.class);
        PlanStatusDao statusDao= (PlanStatusDao) DaoManager.getManager().getDao(PlanStatus.class);
        List<Plant> plants=plantDao.loadAll();
        for (Plant plant: plants) {
           PlanStatus status= statusDao.load(plant.getStatusId())  ;
            plant.setStatus(status);
            List<GroupString> str=stringDao.queryBuilder().where(GroupStringDao.Properties.BelongsId.ge(plant.getId())).orderAsc(GroupStringDao.Properties.Index).list();
            if (str!=null){
              plant.setInfo(parsPlanInfo(str));
            }
            Log.d("ExampleInstrumentedTest",plant.toString());

        }
        return plants;
    }

    private static  PlanInfo parsPlanInfo( List<GroupString> group){
        PlanInfo info=new PlanInfo();
        List<String> step=null;
        List<String> target=null,disturbance=null,reason=null;
        for (GroupString str:group) {
            switch (str.getType()){
                case DbConfig.STRINGTYPE.step:
                    step=checkNullArray(step);
                    step.add(str.getStr());
                    break;
                case DbConfig.STRINGTYPE.target:
                    target=checkNullArray(target);
                    target.add(str.getStr());
                    break;
                case DbConfig.STRINGTYPE.reason:
                    reason=checkNullArray(reason);
                    reason.add(str.getStr());
                    break;
                case DbConfig.STRINGTYPE.disturbance:
                    disturbance=checkNullArray(disturbance);
                    disturbance.add(str.getStr());
                    break;

            }

        }
        info.setStep(step);
        info.setReason(reason);
        info.setTarget(target);
        info.setDisturbance(disturbance);
    return info;
    }
    private static List<String> checkNullArray(List<String> array){
        if (array==null)
            return new ArrayList<>();
        else return array;
    }






 private static void saveStringGroup(GroupStringDao stringDao,long belongsId,int index,String stringtype,String data){

  GroupString groupString=new GroupString();
  groupString.setBelongsId(belongsId);
  groupString.setType(stringtype);
  groupString.setIndex(index);
  groupString.setStr(data);
  stringDao.insertOrReplace(groupString);
 }
}
