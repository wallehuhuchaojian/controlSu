package com.walle.controlself.deffect.adapter.decoration;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.android.flexbox.FlexboxItemDecoration;
import com.walle.controlself.deffect.Config;

/**
 * Created by walle on 2017/8/14.
 */

public class TagsDecoration extends FlexboxItemDecoration {
    public TagsDecoration(Context context) {
        super(context);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
//        super.getItemOffsets(outRect, view, parent, state);
        outRect.left= Config.width/50;
        outRect.right= Config.width/50;
        outRect.top= Config.width/50;
        outRect.bottom= Config.width/50;


    }
}
