package com.li.gohome.presenter;

import android.util.Log;

import com.li.gohome.baen.HomeModel;
import com.li.gohome.baen.SearchModel;
import com.li.gohome.baen.TravelModel;
import com.li.gohome.baen.TravelTabModel;
import com.li.gohome.model.IModel;
import com.li.gohome.model.ModelImpl;
import com.li.gohome.view.IMainView;

import java.io.IOException;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;


public class MainPresenter {
    IMainView mView;
    IModel mModel;
    HomeModel mHomeModel;
    TravelModel travel;
    TravelTabModel travelTab;
    SearchModel searchModel;

    public MainPresenter(IMainView iMainView) {
        this.mView = iMainView;
        mModel = new ModelImpl();
    }

    public void getNetWorkInfo() {
        Observable<HomeModel> observable = mModel.getInfo();
        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HomeModel>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HomeModel homeModel) {
                        mHomeModel = homeModel;
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        mView.getHomeModel(mHomeModel);
                    }
                });
    }

    public void getTravel(String groupChannelCode) {
        Log.v("abbb", "111==");
        Observable<TravelModel> observable = mModel.getTraver(groupChannelCode);
        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TravelModel>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(TravelModel travelModel) {
                        travel = travelModel;
                        Log.v("abbb", "888==" + travel.getResultList().get(0).getArticle().getArticleTitle());
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {
                        mView.getTravelModel(travel);
                    }
                });
    }

    public void getTravelTab() {
        Log.v("abbb", "333==");
        Observable<TravelTabModel> observable = mModel.getTraverTab();
        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TravelTabModel>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(TravelTabModel travelTabModel) {
                        Log.v("abbb", "222==");
                        travelTab = travelTabModel;
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.v("abbb", "222=="+e);
                    }

                    @Override
                    public void onComplete() {
                        Log.v("abbb", "333==");
                        mView.getTravelTabModel(travelTab);
                    }
                });
    }

    public void getSearch(String str) {
        Log.v("eee", "333==");
        Observable<SearchModel> observable = mModel.getSearch(str);
        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SearchModel>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SearchModel model) {
                        Log.v("eee", "222=="+model.getData().get(0).getWord());
                        searchModel = model;
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.v("abbb", "222=="+e);
                    }

                    @Override
                    public void onComplete() {
                        Log.v("eee", "333==");
                        mView.getSearchModel(searchModel);
                    }
                });
    }

}
