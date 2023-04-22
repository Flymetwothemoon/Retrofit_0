package com.example.retrofit_0.post;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.POST;

public interface body {
    @POST("/")
    Call<ResponseBody> requestWeatherBeans(
            @Body bodytext bodytext);
}
