package com.li.gohome.http;

import com.li.gohome.baen.HomeModel;
import com.li.gohome.baen.SearchModel;
import com.li.gohome.baen.TravelModel;
import com.li.gohome.baen.TravelTabModel;
import com.li.gohome.response.TravelPhotoResponse;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface ApiService {

    String TRAVEL_URL = "https://m.ctrip.com/restapi/soa2/16189/json/searchTripShootListForHomePageV2?_fxpcqlniredt=09031014111431397988&__gw_appid=99999999&__gw_ver=1.0&__gw_from=10650013707&__gw_platform=H5";


    @Headers("Content-Type: application/json")
    @GET("/io/flutter_app/json/home_page.json")
    Observable<HomeModel> getHomeModel();

    //@Headers("cid: 09031014111431397988")
    @Headers({
            "cid: 09031014111431397988",
            //"contentType: json",
            "Content-Type: application/json",
            "Accept: application/json"
    })
    @POST
    Observable<TravelModel> getPhoto(@Url String url, @Body TravelPhotoResponse info);

    @Headers("Content-Type: application/json")
    @GET("/io/flutter_app/json/travel_page.json")
    Observable<TravelTabModel> getTab();

    @Headers("Content-Type: application/json")
    @GET
    Observable<SearchModel> getSearch(@Url String url);
}
