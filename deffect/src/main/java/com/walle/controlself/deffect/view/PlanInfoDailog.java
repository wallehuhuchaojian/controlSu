package com.walle.controlself.deffect.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.support.design.widget.BottomSheetDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.greendaolib.pojo.db.GroupString;
import com.walle.controlself.deffect.Config;
import com.walle.controlself.deffect.R;
import com.walle.controlself.deffect.pojo.TagsInfo;

import java.util.List;

/**
 * Created by walle on 2017/8/14.
 */

public class PlanInfoDailog extends BottomSheetDialog {
    private View viewTarget,viewReason,viewStep,viewDisturbance;
    private TextView tvTarget,tvReason,tvStep,tvDisturbance;
    private LinearLayout llContainer;
    private TextView labelTarget,labelReason,labelStep,labelDisturbance;
    private EditText etTarget,etReason,etStep,etDisturbance;
    public PlanInfoDailog(@NonNull Context context) {
        super(context);
        init(context);
    }

    public PlanInfoDailog(@NonNull Context context, @StyleRes int theme) {
        super(context, theme);
        init(context);
    }

    protected PlanInfoDailog(@NonNull Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        init(context);
    }
    private void init(Context context){
       View view= LayoutInflater.from(context).inflate(R.layout.view_plan_info,null);
        setContentView(view);
        viewById();
    }
    private EditComplete editComplete;

    public PlanInfoDailog(@NonNull Context context, EditComplete editComplete) {
        super(context);
        this.editComplete = editComplete;
    }

    public  interface EditComplete{
        void onComplete(List<TagsInfo> tagsInfos);
    }
    private void viewById(){

        tvTarget= (TextView) findViewById(R.id.tv_target);
        tvReason= (TextView) findViewById(R.id.tv_reason);
        tvStep= (TextView) findViewById(R.id.tv_step);
        tvDisturbance= (TextView) findViewById(R.id.tv_disturbance);
        llContainer= (LinearLayout) findViewById(R.id.ll_input);
        tvTarget.setOnClickListener(onClickListener);
        tvReason.setOnClickListener(onClickListener);
        tvStep.setOnClickListener(onClickListener);
        tvDisturbance.setOnClickListener(onClickListener);

    }
    View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view.getId()==tvStep.getId()){
                if (viewStep==null){
                    addItem(Config.TAGSTYPE.step);
                }

            }else if (view.getId()==tvReason.getId()){
                if (viewReason==null){
                    addItem(Config.TAGSTYPE.reason);
                }

            }else if (view.getId()==tvTarget.getId()){
                if (viewTarget==null){
                    addItem(Config.TAGSTYPE.target);
                }
            }else if (view.getId()==tvDisturbance.getId()){
                if (viewDisturbance==null){
                    addItem(Config.TAGSTYPE.disturbance);
                }
            }
        }
    };
    private void addItem(int type){
        TextView label;
        switch (type){
            case Config.TAGSTYPE.step:
                tvStep.setVisibility(View.GONE);
                viewStep=LayoutInflater.from(getContext()).inflate(R.layout.view_item_string_group,null);
                label=viewStep.findViewById(R.id.tv_tag_lebel);
                label.setText("step");
                llContainer.addView(viewStep);
                break;
            case Config.TAGSTYPE.reason:

                tvReason.setVisibility(View.GONE);
                viewReason=LayoutInflater.from(getContext()).inflate(R.layout.view_item_string_group,null);
                label=viewReason.findViewById(R.id.tv_tag_lebel);
                label.setText("reason");
                llContainer.addView(viewReason);

                break;
            case Config.TAGSTYPE.target:
                tvTarget.setVisibility(View.GONE);
                viewTarget=LayoutInflater.from(getContext()).inflate(R.layout.view_item_string_group,null);
                label=viewTarget.findViewById(R.id.tv_tag_lebel);
                label.setText("target");
                llContainer.addView(viewTarget);



                break;
            case Config.TAGSTYPE.disturbance:
                tvDisturbance.setVisibility(View.GONE);
                viewDisturbance=LayoutInflater.from(getContext()).inflate(R.layout.view_item_string_group,null);
                label=viewDisturbance.findViewById(R.id.tv_tag_lebel);
                label.setText("disturbance");
                llContainer.addView(viewDisturbance);

                break;
        }
    }
    public void show(int type){
        removeAll();
        addItem(type);

        show();
    }
    private void removeAll(){
        llContainer.removeAllViews();
        viewTarget=null;
        viewDisturbance=null;
        viewStep=null;
        viewReason=null;
        tvDisturbance.setVisibility(View.VISIBLE);
        tvReason.setVisibility(View.VISIBLE);
        tvStep.setVisibility(View.VISIBLE);
        tvTarget.setVisibility(View.VISIBLE);
    }

}
