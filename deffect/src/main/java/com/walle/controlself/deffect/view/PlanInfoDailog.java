package com.walle.controlself.deffect.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.support.design.widget.BottomSheetDialog;
import android.view.LayoutInflater;
import android.view.View;

import com.walle.controlself.deffect.R;

/**
 * Created by walle on 2017/8/14.
 */

public class PlanInfoDailog extends BottomSheetDialog {
    private View viewTarget,viewReason,viewStep,viewDisturbance;
    public PlanInfoDailog(@NonNull Context context) {
        super(context);
    }

    public PlanInfoDailog(@NonNull Context context, @StyleRes int theme) {
        super(context, theme);
    }

    protected PlanInfoDailog(@NonNull Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }
    private void init(Context context){
       View view= LayoutInflater.from(context).inflate(R.layout.view_plan_info,null);
        setContentView(view);
    }
    private void viewById(){

    }
}
