package com.liu.glory.robticket.api;

import com.liu.glory.robticket.config.BaseUrlConfig;
import com.liu.glory.robticket.utils.LogUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by liu.zhenrong on 2017/2/23.
 */

public final class RetrofitManager {



    static Retrofit retrofit = null;
    static OkHttpClient httpClient = null;

    private static Retrofit getRetrofit(){
        if(null == retrofit){
            retrofit = new  Retrofit.Builder()
                    .baseUrl(BaseUrlConfig.Base_URL).client(getOkhttp())
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    /**
     * 动态代理获取api
     * @param service
     * @param <T>
     * @return
     */
    public static <T> T  getAPI(Class<T> service){

        return getRetrofit().create(service);

    }

    /**
     * 初始化okhttp
     * @return
     */
    private static OkHttpClient getOkhttp(){
        if (null == httpClient) {
            httpClient = new OkHttpClient.Builder().connectTimeout(30l, TimeUnit.SECONDS).readTimeout(30l, TimeUnit.SECONDS)
                    .addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request.Builder builder = chain.request().newBuilder();
                            //builder = addHeaders(builder);
                            LogUtils.e("url:" + chain.request().method() + ":" + chain.request().url());
                            Request request = builder.build();
                            return chain.proceed(request);
                        }
                    })
                    .build();

        }
        return httpClient;
    }


}
