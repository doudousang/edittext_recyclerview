package com.li.gohome.http;

import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {
    private static RetrofitHelper mInstance = null;
    private Retrofit mRetrofit = null;
    private ApiService apiService;

    public static RetrofitHelper getInstance(){
        synchronized (RetrofitHelper.class){
            if (mInstance == null){
                mInstance = new RetrofitHelper();
            }
        }
        return mInstance;
    }
    private RetrofitHelper(){
        init();
    }
    private void init() {
        resetApp();
    }

    private void resetApp() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                try {
                    String text = URLDecoder.decode(message, "utf-8");
                    Log.e("OKHttp-----", text);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    Log.e("OKHttp-----", message);
                }
            }
        });
        //这行必须加 不然默认不打印
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit.Builder builder = new Retrofit.Builder();
        mRetrofit =  builder.baseUrl("http://www.devio.org")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();
    }

    public ApiService getServer(){
        return mRetrofit.create(ApiService.class);
    }

}
