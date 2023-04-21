package com.example.retrofit_0.get;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.retrofit_0.R;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private TextView withNoParams;
    private TextView withParams;
    private TextView query1;
    private TextView queryMap1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        withNoParams = findViewById(R.id.withnoparams);
        withParams = findViewById(R.id.withParams);
        query1 = findViewById(R.id.Query);
        queryMap1 = findViewById(R.id.querymap);
        //无参数GET请求
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.baidu.com/")
                .build();
        WithnoParamsBaiduApi baiduApi = retrofit.create(WithnoParamsBaiduApi.class);
        baiduApi.getBaiduHtml().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    if(response.isSuccessful()) {
                      withNoParams.setText(response.body().string());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("tag","失败");
            }
        });

        //动态配置URL地址

        Retrofit retrofit1 = new Retrofit.Builder().baseUrl("https://so.csdn.net/so/search/")
                .build();
        WithParamsBaiduApi baiduApi1 = retrofit1.create(WithParamsBaiduApi.class);
        baiduApi1.getCall("?q=%E5%8A%A8%E6%80%81%E9%85%8D%E7%BD%AEURL%E5%9C%B0%E5%9D%80%40Path%20retrofit&t=&u=&urw=").enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.isSuccessful()){
                    try {
                        withParams.setText(response.body().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("tag","isFail");
            }
        });

        //Query查询

        Retrofit retrofit2 = new Retrofit.Builder().baseUrl("https://so.csdn.net/so/search/").build();
        Query query = retrofit2.create(Query.class);
        query.getbody("q=%E5%8A%A8%E6%80%81%E9%85%8D%E7%BD%AEURL%E5%9C%B0%E5%9D%80%40Path%20retrofit&t=&u=&urw=").enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
            if(response.isSuccessful()) {
                try {
                    query1.setText(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.d("tag","io");
                }
            }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("tag","失败");
            }
        });

//        MapQuery查询
        Retrofit retrofit3 = new Retrofit.Builder().baseUrl("https://so.csdn.net/so/search/").build();
        Map<String,String>map = new HashMap<>();
        map.put("q","%E5%8A%A8%E6%80%81%E9%85%8D%E7%BD%AEURL%E5%9C%B0%E5%9D%80%40Path%20retrofit&t=&u=");
        map.put("urw","");
        QueryMap queryMap = retrofit3.create(QueryMap.class);
        queryMap.getCall(map).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.isSuccessful()){
                    try {
                      queryMap1.setText(response.body().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                        Log.d("tag","net");
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