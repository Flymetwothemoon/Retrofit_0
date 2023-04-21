package com.example.retrofit_0.get;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface WithnoParamsBaiduApi {
    @GET("/")
    Call<ResponseBody> getBaiduHtml();
}