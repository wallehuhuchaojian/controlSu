package com.walle.controlself.deffect.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.walle.controlself.deffect.R;
import com.walle.controlself.deffect.pojo.ExtensibleInfo;

import java.util.List;

/**
 * Created by walle on 2017/8/15.
 */

public class ExtensibleAdapter extends RecyclerView.Adapter<ExtensibleAdapter.MainHolder>{
    List<ExtensibleInfo> infos;

    public ExtensibleAdapter(List<ExtensibleInfo> infos) {
        this.infos = infos;
    }

    public List<ExtensibleInfo> getInfos() {
        return infos;
    }

    public void setInfos(List<ExtensibleInfo> infos) {
        this.infos = infos;
    }

    @Override
    public MainHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MainHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_recycler,null));
    }

    @Override
    public void onBindViewHolder(MainHolder holder, int position) {
        ExtensibleInfo info=infos.get(position);
        holder.info=info;

    }

    @Override
    public int getItemCount() {
        if (infos==null)
        return 0;

        return infos.size();

    }

    public  class  MainHolder extends RecyclerView.ViewHolder {
        RecyclerView recycler;
        ExtensibleInfo info;
        public MainHolder(View itemView) {
            super(itemView);
            recycler= (RecyclerView) itemView;

        }
        public void updateItem(){

        }
    }
}
