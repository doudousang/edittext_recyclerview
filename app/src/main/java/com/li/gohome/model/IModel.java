package com.li.gohome.model;


import com.li.gohome.baen.HomeModel;
import com.li.gohome.baen.SearchModel;
import com.li.gohome.baen.TravelModel;
import com.li.gohome.baen.TravelTabModel;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

public interface IModel {
    //提供home数据
    public Observable<HomeModel> getInfo();

    //存储数据
    public void setInfo(String info);

    //提供旅拍页数据
    public Observable<TravelModel> getTraver(String groupChannelCode);

    //提供旅拍类别数据
    public Observable<TravelTabModel> getTraverTab();

    //提供搜索数据
    public Observable<SearchModel> getSearch(String searchStr);
}
