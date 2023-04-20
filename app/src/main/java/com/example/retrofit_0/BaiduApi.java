package com.example.retrofit_0;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;

public interface BaiduApi {
    @GET("/")
    Call<ResponseBody> getBaiduHtml();
}