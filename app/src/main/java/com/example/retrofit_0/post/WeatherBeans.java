package com.example.retrofit_0.post;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;


public class WeatherBeans implements Serializable {

    @SerializedName("success")
    public String success;
    @SerializedName("result")
    public List<ResultDTO> result;

    public static WeatherBeans objectFromData(String str) {

        return new Gson().fromJson(str, WeatherBeans.class);
    }
}
