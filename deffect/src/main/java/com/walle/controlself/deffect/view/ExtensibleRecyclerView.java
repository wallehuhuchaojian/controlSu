package com.walle.controlself.deffect.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * Created by walle on 2017/8/15.
 */

public class ExtensibleRecyclerView extends RecyclerView{
    public ExtensibleRecyclerView(Context context) {
        super(context);
    }

    public ExtensibleRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ExtensibleRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
}
