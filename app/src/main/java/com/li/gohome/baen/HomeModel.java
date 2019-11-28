package com.li.gohome.baen;

/**
 * Copyright 2019 aTool.org
 */
import java.util.List;

/**
 * Auto-generated: 2019-09-12 14:44:4
 *
 * @author aTool.org (i@aTool.org)
 * @website http://www.atool9.com/json2javabean.php
 */
public class HomeModel {

    private Config config;
    private List<CommonModel> bannerList;
    private List<CommonModel> localNavList;
    private GridNav gridNav;
    private List<CommonModel> subNavList;
    private SalesBox salesBox;
    public void setConfig(Config config) {
        this.config = config;
    }
    public Config getConfig() {
        return config;
    }

    public void setbannerList(List<CommonModel> bannerList) {
        this.bannerList = bannerList;
    }
    public List<CommonModel> getbannerList() {
        return bannerList;
    }

    public void setlocalNavList(List<CommonModel> localNavList) {
        this.localNavList = localNavList;
    }
    public List<CommonModel> getlocalNavList() {
        return localNavList;
    }

    public void setGridnav(GridNav gridNav) {
        this.gridNav = gridNav;
    }
    public GridNav getGridnav() {
        return gridNav;
    }

    public void setsubNavList(List<CommonModel> subNavList) {
        this.subNavList = subNavList;
    }
    public List<CommonModel> getsubNavList() {
        return subNavList;
    }

    public void setSalesbox(SalesBox salesBox) {
        this.salesBox = salesBox;
    }
    public SalesBox getSalesbox() {
        return salesBox;
    }

}
