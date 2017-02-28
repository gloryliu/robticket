package com.liu.glory.robticket.api;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by liu.zhenrong on 2017/2/28.
 */

public abstract class APICallBack<T> implements Callback<T> {
    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        onSuccess(call, response);
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        onError(call, t);
    }
    public abstract void onSuccess(Call<T> call, Response<T> response);
    public abstract void onError(Call<T> call, Throwable t);
}
