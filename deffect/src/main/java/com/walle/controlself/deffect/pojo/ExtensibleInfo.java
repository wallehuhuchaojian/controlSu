package com.walle.controlself.deffect.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by walle on 2017/8/16.
 */

public class ExtensibleInfo {
    private int type;
    private List<String> datas=new ArrayList<>();
    private String title;
    private boolean folded=false;
    private int layoutId,headerId;

    private float itemHeight=0.1f,headerHeight=0.1f;
    private boolean needHeader=true;

    public int getLayoutId() {
        return layoutId;
    }

    public void setLayoutId(int layoutId) {
        this.layoutId = layoutId;
    }



    public int getHeaderId() {
        return headerId;
    }

    public void setHeaderId(int headerId) {
        this.headerId = headerId;
    }

    public float getItemHeight() {
        return itemHeight;
    }

    public void setItemHeight(float itemHeight) {
        this.itemHeight = itemHeight;
    }

    public float getHeaderHeight() {
        return headerHeight;
    }

    public void setHeaderHeight(float headerHeight) {
        this.headerHeight = headerHeight;
    }

    public boolean isNeedHeader() {
        return needHeader;
    }

    public void setNeedHeader(boolean needHeader) {
        this.needHeader = needHeader;
    }

    public ExtensibleInfo(int type, String title, boolean needHeader,int layoutId, int headerId) {
        this.layoutId = layoutId;
        this.headerId = headerId;
        this.type = type;
        this.title = title;
        this.needHeader = needHeader;
    }

    public ExtensibleInfo(int type, String title, boolean needHeader) {
        this.type = type;
        this.title = title;
        this.needHeader = needHeader;
    }

    public boolean isFolded() {
        return folded;
    }

    public void setFolded(boolean folded) {
        folded = folded;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<String> getDatas() {
        return datas;
    }

    public void setDatas(List<String> datas) {
        this.datas = datas;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
