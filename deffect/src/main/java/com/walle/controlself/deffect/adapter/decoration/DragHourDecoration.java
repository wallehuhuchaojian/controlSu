package com.walle.controlself.deffect.adapter.decoration;

import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.walle.controlself.deffect.Config;
import com.walle.controlself.deffect.MainActivity;

/**
 * Created by walle on 2017/7/27.
 */

public class DragHourDecoration extends RecyclerView.ItemDecoration {
    public int devider;
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
//        super.getItemOffsets(outRect, view, parent, state);
        devider= Config.width/50;
        int position = parent.getChildAdapterPosition(view);
        RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            int spanCount = ((GridLayoutManager) layoutManager).getSpanCount();
            int total=parent.getAdapter().getItemCount();
            int p=position%spanCount;
            int lan=total/spanCount;
            int h=position/spanCount;
            outRect.left=devider;
            outRect.right=devider;
            outRect.top=devider;
            outRect.bottom=devider;
//            if (p!=spanCount-1){
//                outRect.right=devider;
//            }else {
//                outRect.right=0;
//            }
//
//            if (h==lan-1){
//                outRect.bottom=0;
//            }

        }
    }
}
