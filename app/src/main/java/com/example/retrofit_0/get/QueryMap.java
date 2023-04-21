package com.example.retrofit_0.get;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;

public interface QueryMap {
@GET("ip")
Call<ResponseBody>getCall(@retrofit2.http.QueryMap Map<String,String>map);
}
