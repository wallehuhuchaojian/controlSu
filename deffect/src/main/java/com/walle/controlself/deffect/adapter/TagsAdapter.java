package com.walle.controlself.deffect.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.walle.controlself.deffect.R;
import com.walle.controlself.deffect.pojo.TagsInfo;

import java.util.List;

/**
 * Created by walle on 2017/8/14.
 */

public class TagsAdapter extends RecyclerView.Adapter<TagsAdapter.TagHolder> {
   private List<TagsInfo> tagsInfos;
    private TagsClick tagsClick;

    public TagsAdapter(List<TagsInfo> tagsInfos, TagsClick tagsClick) {
        this.tagsInfos = tagsInfos;
        this.tagsClick = tagsClick;
    }



    public void setTagsInfos(List<TagsInfo> tagsInfos) {
        this.tagsInfos = tagsInfos;
    }
    public interface TagsClick{
        void onClick(int type);
    }

    @Override
    public TagHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TagHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tag,null));
    }

    @Override
    public void onBindViewHolder(TagHolder holder, int position) {
        final TagsInfo tagsInfo=tagsInfos.get(position);
        holder.tvTag.setText(tagsInfo.getTag());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tagsClick!=null)
                    tagsClick.onClick(tagsInfo.getType());
            }
        });
    }

    @Override
    public int getItemCount() {
        if (tagsInfos==null)
        return 0;
        return tagsInfos.size();
    }

    public class TagHolder extends RecyclerView.ViewHolder {
        public TextView tvTag;
        public TagHolder(View itemView) {
            super(itemView);
            tvTag=itemView.findViewById(R.id.tv_tag);
        }
    }
}
