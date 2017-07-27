package com.walle.controlself.deffect.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.walle.controlself.deffect.Config;
import com.walle.controlself.deffect.MainActivity;
import com.walle.controlself.deffect.R;
import com.walle.controlself.deffect.dragSelector.DragSelectRecyclerViewAdapter;
import com.walle.controlself.deffect.pojo.EventsInfo;

import java.util.List;

/**
 * Created by walle on 2017/7/26.
 */

public class DayDragAdapter extends DragSelectRecyclerViewAdapter<DayDragAdapter.DragHolder>implements View.OnClickListener, View.OnLongClickListener {
    List<EventsInfo> eventsInfos;
    public interface ClickListener {
        void onClick(int index);

        void onLongClick(int index);
    }
    private final ClickListener mCallback;

    public DayDragAdapter(ClickListener callback) {
        super();
        mCallback = callback;
    }
    @Override
    public DragHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DragHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_drag_day_hour,parent,false));
    }

    @Override
    public void onBindViewHolder(DragHolder holder, int position) {
        holder.tvHour.setText(position+"");
        if (isIndexSelected(position)) {
            holder.viewCover.setBackgroundColor(holder.itemView.getResources().getColor(R.color.colorHourDragSelect));
        }else {
            holder.viewCover.setBackgroundColor(Color.TRANSPARENT);
        }
        final Drawable d;
        final Context c = holder.itemView.getContext();

//        if (isIndexSelected(position)) {
//            d = new ColorDrawable(ContextCompat.getColor(c, R.color.colorHourDragSelect));
//        } else {
//            d = null;
//        }
//
//        holder.viewCover.setImageDrawable(d);
        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(this);
        holder.itemView.setOnLongClickListener(this);

    }

    @Override
    public int getItemCount() {
        return 24;
    }

    @Override
    public void onClick(View v) {
        if (v.getTag() != null) {
            int index = (int) v.getTag();
            if (mCallback != null) mCallback.onClick(index);
        }
    }

    @Override
    public boolean onLongClick(View v) {
        if (v.getTag() != null) {
            int index = (int) v.getTag();
            if (mCallback != null) mCallback.onLongClick(index);
            return true;
        }
        return false;
    }


    public  class DragHolder extends RecyclerView.ViewHolder{
        public EventsInfo info;
        public TextView tvHour;
        public View viewCover;
        public RelativeLayout container;
        public DragHolder(View itemView) {
            super(itemView);
            tvHour=itemView.findViewById(R.id.tv_hour);
            viewCover=itemView.findViewById(R.id.view_cover);
            container=itemView.findViewById(R.id.rl_container);
            RelativeLayout.LayoutParams params= (RelativeLayout.LayoutParams) container.getLayoutParams();
            params.width=(Config.width-16*Config.width/50)/8 ;
            params.height=params.width;
            container.setLayoutParams(params);
        }
    }
}
