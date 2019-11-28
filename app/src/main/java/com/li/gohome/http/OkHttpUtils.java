package com.li.gohome.http;

import okhttp3.OkHttpClient;

/**
 * Created by DG on 2018/5/24.
 */

public class OkHttpUtils {

    private OkHttpClient build;

    public OkHttpClient getBuild() {
        return build;
    }

    private OkHttpUtils() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        build = builder.hostnameVerifier(SSLSocketClient.getHostnameVerifier())
                .sslSocketFactory(SSLSocketClient.getSSLSocketFactory(), new SSLTrustAllManager()).build();
    }

    private static class SingletonHolder {
        private static OkHttpUtils instance = new OkHttpUtils();
    }

    public static OkHttpUtils getOkHttpClient() {
        return SingletonHolder.instance;
    }
}
