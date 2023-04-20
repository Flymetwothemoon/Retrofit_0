package com.example.retrofit_0;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //无参数GET请求
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.baidu.com/")
                .build();
        WithnoParamsBaiduApi baiduApi = retrofit.create(WithnoParamsBaiduApi.class);
        baiduApi.getBaiduHtml().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                try {
//                    if(response.isSuccessful()) {
//                        Log.d("tag", response.body().string());
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("tag","失败");
            }
        });

        //动态配置URL地址

//        Retrofit retrofit1 = new Retrofit.Builder().baseUrl("https://so.csdn.net/so/search/")
//                .build();
//        WithParamsBaiduApi baiduApi1 = retrofit1.create(WithParamsBaiduApi.class);
//        baiduApi1.getCall("?q=%E5%8A%A8%E6%80%81%E9%85%8D%E7%BD%AEURL%E5%9C%B0%E5%9D%80%40Path%20retrofit&t=&u=&urw=").enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                if(response.isSuccessful()){
//                    try {
//                        Log.d("tag",response.body().string());
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//                Log.d("tag","isFail");
//            }
//        });

//        Retrofit retrofit2 = new Retrofit.Builder().baseUrl("https://so.csdn.net/so/search/").build();
//        Query query = retrofit2.create(Query.class);
//        query.getbody("q=%E5%8A%A8%E6%80%81%E9%85%8D%E7%BD%AEURL%E5%9C%B0%E5%9D%80%40Path%20retrofit&t=&u=&urw=").enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//            if(response.isSuccessful()) {
//                try {
//                    Log.d("tag", response.body().string());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                    Log.d("tag","io");
//                }
//            }
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//                Log.d("tag","失败");
//            }
//        });
//
        Retrofit retrofit3 = new Retrofit.Builder().baseUrl("https://blog.csdn.net/guohaosir/").build();
        Map<String,String>map = new HashMap<>();
        map.put("one","guohaosir/");
        map.put("two","article/details/78942485" +
                "?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522168199273116800227447873%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fall.%2522%257D&request_id=168199273116800227447873&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~first_rank_ecpm_v1~rank_v31_ecpm-1-78942485-null-null.142^v85^pc_search_v2,239^v2^insert_chatgpt&utm_term=%E5%8A%A8%E6%80%81%E9%85%8D%E7%BD%AEURL%E5%9C%B0%E5%9D%80%40Path%20retrofit&spm=1018.2226.3001.4187");
        QueryMap queryMap = retrofit3.create(QueryMap.class);
        queryMap.getCall(map).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.isSuccessful()){
                    try {
                        Log.d("tag",response.body().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("tag","失败");
//                "1"
            }
        });

    }
}