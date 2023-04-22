package com.example.retrofit_0.post;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface postField {
    @FormUrlEncoded
    @POST("/")
    Call<WeatherBeans> requestWeatherBeans(
            @Field("app") String app,
            @Field("weaid") String weaid,
            @Field("appkey") String appkey,
            @Field("sign") String sign,
            @Field("format") String format);
}
