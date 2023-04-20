package com.example.retrofit_0;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WithParamsBaiduApi {
    @GET("{path}")
    Call<ResponseBody>getCall(@Path("path")String path);
}
