package com.li.gohome.view;

import com.li.gohome.baen.HomeModel;
import com.li.gohome.baen.SearchModel;
import com.li.gohome.baen.TravelModel;
import com.li.gohome.baen.TravelTabModel;

public interface IMainView {
    void getHomeModel(HomeModel homeModel);
    void getTravelModel(TravelModel travelModel);
    void getTravelTabModel(TravelTabModel travelTabModel);
    void getSearchModel(SearchModel searchModel);
}
