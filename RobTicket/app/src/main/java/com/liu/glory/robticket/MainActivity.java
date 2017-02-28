package com.liu.glory.robticket;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.liu.glory.robticket.api.APICallBack;
import com.liu.glory.robticket.api.BaseAPIimp.QueryTicketAPI;
import com.liu.glory.robticket.api.BaseAPIimp.UserInfoAPI;
import com.liu.glory.robticket.api.RetrofitManager;
import com.liu.glory.robticket.bean.LeftTicketBean;
import com.liu.glory.robticket.utils.LogUtils;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_text)
    TextView tv_text;
    @BindView(R.id.iv_image)
    ImageView iv_image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        QueryTicketAPI api = RetrofitManager.getAPI(QueryTicketAPI.class);

        Call<LeftTicketBean> callBack = api.query("2017-02-2","BJP","CDW","ADULT");
        callBack.enqueue(new APICallBack<LeftTicketBean>() {
            @Override
            public void onSuccess(Call<LeftTicketBean> call, Response<LeftTicketBean> response) {
                tv_text.setText(response.body().isStatus()+"");
                LogUtils.e("onSuccess");
            }

            @Override
            public void onError(Call<LeftTicketBean> call, Throwable t) {
                LogUtils.e("onError");
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        iv_image = (ImageView) findViewById(R.id.iv_image);
        iv_image.setColorFilter(getResources().getColor(R.color.color_eeeeee), PorterDuff.Mode.MULTIPLY );
    }
}
