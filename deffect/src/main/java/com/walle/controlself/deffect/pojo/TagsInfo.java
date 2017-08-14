package com.walle.controlself.deffect.pojo;

/**
 * Created by walle on 2017/8/14.
 */

public class TagsInfo {
    public TagsInfo(String tag, int type, boolean clickAble) {
        this.tag = tag;
        this.type = type;
        this.clickAble = clickAble;
    }

    private String tag;
    private int type;
    private boolean clickAble;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isClickAble() {
        return clickAble;
    }

    public void setClickAble(boolean clickAble) {
        this.clickAble = clickAble;
    }
}
