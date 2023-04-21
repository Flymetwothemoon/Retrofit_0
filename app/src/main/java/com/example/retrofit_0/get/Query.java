package com.example.retrofit_0.get;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Query {
    @GET("ip")
    Call<ResponseBody>getbody(@retrofit2.http.Query("ip")String ip);
}
