package com.liu.glory.robticket;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.liu.glory.robticket.api.BaseAPIimp.UserInfoAPI;
import com.liu.glory.robticket.api.RetrofitManager;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_text)
    TextView tv_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        UserInfoAPI userInfoAPI = RetrofitManager.getAPI("www.baidu.com", UserInfoAPI.class);
        try {
            Response<ResponseBody> response1 = userInfoAPI.robots().execute();
            tv_text.setText(response1.body().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
