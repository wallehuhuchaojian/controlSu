package com.walle.controlself.deffect;

import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.greendaolib.pojo.db.GroupString;
import com.example.greendaolib.pojo.db.PlanInfo;
import com.example.greendaolib.pojo.db.Plant;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.walle.controlself.deffect.adapter.TagsAdapter;
import com.walle.controlself.deffect.adapter.decoration.TagsDecoration;
import com.walle.controlself.deffect.pojo.TagsInfo;
import com.walle.controlself.deffect.view.PlanInfoDailog;

import java.util.ArrayList;
import java.util.List;

public class EventDetailActivity extends AppCompatActivity implements TagsAdapter.TagsClick,PlanInfoDailog.EditComplete {
    private String TAG="EventDetailActivity";
    private TextView tvBack,tvConfirm,tvName;
    TagsAdapter tagsAdapter;
    RecyclerView tagsRecycler;
    BottomSheetDialog bottomSheetDialog;
    private PlanInfoDailog infoDailog;
    Plant plant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);
//        Toolbar toolbar =getActionBar().getT;
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        viewId();
        Bundle bundle=getIntent().getExtras();
        if (bundle==null)
        editeName();
    }
        private void viewId(){
            tvBack= (TextView) findViewById(R.id.tv_back);
            tvConfirm= (TextView) findViewById(R.id.tv_confirm);
            tvName= (TextView) findViewById(R.id.tv_name);
            tagsRecycler= (RecyclerView) findViewById(R.id.recycler_tags);
            tvConfirm.setOnClickListener(onClickListener);
            tvConfirm.setOnClickListener(onClickListener);
            tvName.setOnClickListener(onClickListener);
            initTags();
    }
    private void initTags(){
        tagsAdapter=new TagsAdapter(initTagsData(),this);
        FlexboxLayoutManager layoutManager=new FlexboxLayoutManager(this);
        layoutManager.setFlexWrap(FlexWrap.WRAP);
        tagsRecycler.setAdapter(tagsAdapter);
        tagsRecycler.setLayoutManager(layoutManager);
        tagsRecycler.addItemDecoration(new TagsDecoration(this));
    }
    private List<TagsInfo> initTagsData(){
        List<TagsInfo> tagsInfos=new ArrayList<>();
        tagsInfos.add(new TagsInfo("disturbance",Config.TAGSTYPE.disturbance,true));
        tagsInfos.add(new TagsInfo("reason",Config.TAGSTYPE.reason,true));
        tagsInfos.add(new TagsInfo("step",Config.TAGSTYPE.step,true));
        tagsInfos.add(new TagsInfo("summary",Config.TAGSTYPE.summary,true));
        tagsInfos.add(new TagsInfo("target",Config.TAGSTYPE.target,true));
        tagsInfos.add(new TagsInfo("target",Config.TAGSTYPE.target,true));
        return tagsInfos;
    }
    View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view.getId()==tvBack.getId()){
                finish();
            }else if (view.getId()==tvConfirm.getId()){

            }else if (view.getId()==tvName.getId()){
                editeName();
            }
        }
    };
    private void editeName(){
        if (bottomSheetDialog==null) {
            bottomSheetDialog = new BottomSheetDialog(this);
            View view = LayoutInflater.from(this).inflate(R.layout.view_edit_name, null);
            bottomSheetDialog.setContentView(view);
            final EditText editText = view.findViewById(R.id.ed_name);
            TextView tvConfirm = view.findViewById(R.id.tv_start);
            tvConfirm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!TextUtils.isEmpty(editText.getText().toString())) {
                        if (bottomSheetDialog.isShowing()) {
                            bottomSheetDialog.dismiss();

                        }
                        tvName.setText(editText.getText().toString());
                        if (plant==null){
                            plant=Plant.createNew();
                            plant.setName(tvName.getText().toString());
                        }
                    }
                }
            });
        }
        bottomSheetDialog.show();
    }

private void showType(int type){
    if (infoDailog==null){
        infoDailog=new PlanInfoDailog(this,this);
    }
    infoDailog.show(type);
}

    @Override
    public void onClick(int type) {
        showType(type);
    }

    private void addInfo(TagsInfo tagsInfo){
        if (plant.getInfo()==null){
            plant.setInfo(new PlanInfo());
        }
        switch (tagsInfo.getType()){
            case Config.TAGSTYPE.step:
                if (plant.getInfo().getStep()==null){
                    plant.getInfo().setStep(new ArrayList<String>());
                }
                plant.getInfo().getStep().add(tagsInfo.getTag());
                break;
            case Config.TAGSTYPE.reason:
                if (plant.getInfo().getReason()==null){
                    plant.getInfo().setReason(new ArrayList<String>());
                }
                plant.getInfo().getReason().add(tagsInfo.getTag());
                break;
            case Config.TAGSTYPE.target:
                if (plant.getInfo().getTarget()==null){
                    plant.getInfo().setTarget(new ArrayList<String>());
                }
                plant.getInfo().getTarget().add(tagsInfo.getTag());
                break;
            case Config.TAGSTYPE.disturbance:
                if (plant.getInfo().getDisturbance()==null){
                    plant.getInfo().setDisturbance(new ArrayList<String>());
                }
                plant.getInfo().getDisturbance().add(tagsInfo.getTag());
                break;


        }
    }
    @Override
    public void onComplete(List<TagsInfo> tagsInfos) {
        if (tagsInfos==null)
            return;
        for (int i = 0; i < tagsInfos.size(); i++) {
            addInfo(tagsInfos.get(i));

        }
    }
}
