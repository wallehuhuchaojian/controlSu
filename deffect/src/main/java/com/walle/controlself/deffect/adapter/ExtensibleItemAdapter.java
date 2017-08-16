package com.walle.controlself.deffect.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.walle.controlself.deffect.R;
import com.walle.controlself.deffect.pojo.ExtensibleInfo;

/**
 * Created by walle on 2017/8/16.
 */

public class ExtensibleItemAdapter extends RecyclerView.Adapter<ExtensibleItemAdapter.ProxyHolder> {
    ExtensibleInfo info;
    private static int ITEM_TYPE_HEADER=1;
    private static int ITEM_TYPE_ITEM=2;

    public ExtensibleItemAdapter(ExtensibleInfo info) {
        this.info = info;
    }
    @Override
    public ProxyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType==ITEM_TYPE_HEADER){
            return  new HeaderHolder(LayoutInflater.from(parent.getContext()).inflate(info.getHeaderId(),null));
        }else {
            return   new HeaderHolder(LayoutInflater.from(parent.getContext()).inflate(info.getLayoutId(),null));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (info.isNeedHeader()){
            return ITEM_TYPE_HEADER;
        }else {
            return ITEM_TYPE_ITEM;
        }

    }

    @Override
    public void onBindViewHolder(ProxyHolder holder, int position) {
        int type=getItemViewType(position);
        if (type==ITEM_TYPE_HEADER){

        }

    }
    private void bindHeader(HeaderHolder headerHolder){

    }
    @Override
    public int getItemCount() {
        if (info==null)
        return 0;
        int count=0;
        if (info.isNeedHeader())
            count++;
        if (!info.isFolded()){
           count=count+info.getDatas().size();
        }
        return count;
    }

    public class ProxyHolder extends RecyclerView.ViewHolder {
        public ProxyHolder(View itemView) {
            super(itemView);
        }
    }
    public class  HeaderHolder extends ProxyHolder {
        private TextView tvTitle;
        public HeaderHolder(View itemView) {
            super(itemView);
            tvTitle=itemView.findViewById(R.id.tv_title);
        }
    }
    public class ItemHolder extends ProxyHolder {
        public ItemHolder(View itemView) {
            super(itemView);
        }
    }
}
