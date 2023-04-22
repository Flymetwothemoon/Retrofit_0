package com.example.retrofit_0.post;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.retrofit_0.R;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostActivity extends AppCompatActivity {
    private TextView field;
    private TextView body1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        field = findViewById(R.id.Field);
        body1 = findViewById(R.id.body);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.k780.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        postField netService = retrofit.create(postField.class);
        Call<WeatherBeans> call = netService.requestWeatherBeans("weather.future","1","10003","b59bc3ef6191eb9f747dd4e83c99f2a4","json");
        call.enqueue(new Callback<WeatherBeans>() {
            @Override
            public void onResponse(Call<WeatherBeans> call, Response<WeatherBeans> response) {
                if(response.isSuccessful()){
                    WeatherBeans beans = response.body();
                    for (int i = 0;i<beans.result.size();i++) {
                       field.setText(beans.result.get(i).citynm);
                    }
                }
                Log.d("tag2",response.body().success);

            }

            @Override
            public void onFailure(Call<WeatherBeans> call, Throwable t) {
                Log.d("tag2","失败"+t);
            }
        });

        Retrofit retrofit1 = new Retrofit.Builder().baseUrl("http://api.k780.com/").
                addConverterFactory(GsonConverterFactory.create())
                .build();
        body body = retrofit1.create(com.example.retrofit_0.post.body.class);
        bodytext bodytext = new bodytext("weather.future","1","10003","b59bc3ef6191eb9f747dd4e83c99f2a4","json");
        Call<ResponseBody>call1 = body.requestWeatherBeans(bodytext);
        call1.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.isSuccessful()){
                    try {
                        body1.setText(response.body().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });

    }
}