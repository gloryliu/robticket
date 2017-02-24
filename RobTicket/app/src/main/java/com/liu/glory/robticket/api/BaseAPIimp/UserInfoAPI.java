package com.liu.glory.robticket.api.BaseAPIimp;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by liu.zhenrong on 2017/2/23.
 */

public interface UserInfoAPI {
    @GET("https://www.baidu.com/?tn=62095104_oem_dg")
    Call<ResponseBody> robots();
}
