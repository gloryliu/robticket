package com.liu.glory.robticket.api;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by liu.zhenrong on 2017/2/23.
 */

public final class RetrofitManager {



    static Retrofit retrofit = null;

    static HostSelectionInterceptor hostSelectionInterceptor;



    public static <T> T  getAPI(String baseurl, Class<T> service){

        hostSelectionInterceptor = new HostSelectionInterceptor();
        hostSelectionInterceptor.setHost(baseurl);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(hostSelectionInterceptor)
                .build();

        retrofit = new Retrofit.Builder()
                .callFactory(okHttpClient)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(service);

    }

    static final class HostSelectionInterceptor implements Interceptor {
        private volatile String host;

        public void setHost(String host) {
            this.host = host;
        }

        @Override public okhttp3.Response intercept(Interceptor.Chain chain){
            Request request = chain.request();
            String host = this.host;
            if (host != null) {
                HttpUrl newUrl = request.url().newBuilder()
                        .host(host)
                        .build();
                request = request.newBuilder()
                        .url(newUrl)
                        .build();
            }
            try {
                return chain.proceed(request);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
