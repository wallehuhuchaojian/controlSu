package com.walle.controlself.deffect.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.greendaolib.pojo.db.EventsInfo;
import com.walle.controlself.deffect.R;

import java.util.List;

/**
 * Created by walle on 2017/7/31.
 */

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.EventHolder> {
    List<EventsInfo> datas;

    public EventsAdapter(List<EventsInfo> datas) {
        this.datas = datas;
    }

    public EventsAdapter() {
    }

    public List<EventsInfo> getDatas() {
        return datas;
    }

    public void setDatas(List<EventsInfo> datas) {
        this.datas = datas;
    }

    @Override
    public EventHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new EventHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_events,null));
    }

    @Override
    public void onBindViewHolder(EventHolder holder, int position) {
        EventsInfo info=datas.get(position);
        holder.tvTitle.setText(info.getDoWhat());
        holder.tvSub.setText(info.getDoWanna());

    }

    @Override
    public int getItemCount() {
        if (datas==null)
        return 0;
        return datas.size();
    }

    public class EventHolder extends RecyclerView.ViewHolder{
        public TextView tvTitle,tvSub;
        public EventHolder(View itemView) {
            super(itemView);
            tvTitle=itemView.findViewById(R.id.tv_event_todo);
            tvSub=itemView.findViewById(R.id.tv_event_tobe);

        }
    }
}
