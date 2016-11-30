package com.shareniu.bbs.vo;

import java.util.List;

public class SysAuthVo {
    private Integer id;

    private String text;

    private String url;

    private String itemId;//菜单id

    /*****************树字段start****************/

    private int subCount;//子菜单总数

    private List<SysAuthVo> children;//子集合

    private boolean checked = false;//是否是选中叶 默认false

    private String cls;//父级默认 folder  子集合为""

    private boolean leaf = true;//父为false 子为true

    private String iconCls ;

    /*****************树字段end****************/



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getSubCount() {
        return subCount;
    }

    public void setSubCount(int subCount) {
        this.subCount = subCount;
    }

    public List<SysAuthVo> getChildren() {
        return children;
    }

    public void setChildren(List<SysAuthVo> children) {
        this.children = children;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getCls() {
        return cls;
    }

    public void setCls(String cls) {
        this.cls = cls;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }
}