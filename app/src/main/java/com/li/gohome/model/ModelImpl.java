package com.li.gohome.model;


import android.util.Log;

import com.li.gohome.baen.HomeModel;
import com.li.gohome.baen.SearchModel;
import com.li.gohome.baen.TravelModel;
import com.li.gohome.baen.TravelTabModel;
import com.li.gohome.http.RetrofitHelper;
import com.li.gohome.response.PagePara;
import com.li.gohome.response.TravelPhotoResponse;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

public class ModelImpl implements IModel {
    String TRAVEL_URL = "https://m.ctrip.com/restapi/soa2/16189/json/searchTripShootListForHomePageV2?_fxpcqlniredt=09031014111431397988&__gw_appid=99999999&__gw_ver=1.0&__gw_from=10650013707&__gw_platform=H5";
    String params = "{\n" +
            "  \"districtId\": -1,\n" +
            "  \"groupChannelCode\": \"RX-OMF\",\n" +
            "  \"type\": null,\n" +
            "  \"lat\": -180,\n" +
            "  \"lon\": -180,\n" +
            "  \"locatedDistrictId\": 0,\n" +
            "  \"pagePara\": {\n" +
            "    \"pageIndex\": 1,\n" +
            "    \"pageSize\": 10,\n" +
            "    \"sortType\": 9,\n" +
            "    \"sortDirection\": 0\n" +
            "  },\n" +
            "  \"imageCutType\": 1,\n" +
            "  \"contentType\": \"json\"\n" +
            "}";
    @Override
    public Observable<HomeModel> getInfo() {
        Observable<HomeModel> observable = post();
        return observable;
    }

    private Observable<HomeModel> post() {
        Observable<HomeModel> observable = RetrofitHelper.getInstance().getServer().getHomeModel();
        return observable;
    }

    @Override
    public void setInfo(String info) {

    }

    @Override
    public Observable<TravelModel> getTraver(String groupChannelCode) {
        RequestBody body=RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),params);
        //Observable<TravelModel> observable = RetrofitHelper.getInstance().getServer().getPhoto(TRAVEL_URL,body);
        PagePara pagePara = new PagePara(1,10,9,0);
        TravelPhotoResponse travelPhotoResponse = new TravelPhotoResponse(-1,groupChannelCode,
                null,-180,-180,0,pagePara,1,"json");
        Observable<TravelModel> observable = RetrofitHelper.getInstance().getServer().getPhoto(TRAVEL_URL,travelPhotoResponse);
        return observable;
    }

    @Override
    public Observable<TravelTabModel> getTraverTab() {
        Observable<TravelTabModel> observable = RetrofitHelper.getInstance().getServer().getTab();
        return observable;
    }

    @Override
    public Observable<SearchModel> getSearch(String searchStr) {
        Observable<SearchModel> observable = RetrofitHelper.getInstance().getServer().getSearch(searchStr);
        return observable;
    }
}
