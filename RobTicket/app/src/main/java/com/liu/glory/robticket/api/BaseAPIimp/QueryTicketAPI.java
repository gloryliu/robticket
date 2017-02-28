package com.liu.glory.robticket.api.BaseAPIimp;

import com.liu.glory.robticket.bean.LeftTicketBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by liu.zhenrong on 2017/2/28.
 */

public interface QueryTicketAPI {
    @GET("/otn/leftTicket/log")
    Call<LeftTicketBean> query(@Query("leftTicketDTO.train_date") String train_date,
                              @Query("leftTicketDTO.from_station") String from_station,
                              @Query("leftTicketDTO.to_station") String to_station,
                              @Query("purpose_codes") String purpose_codes);
}
