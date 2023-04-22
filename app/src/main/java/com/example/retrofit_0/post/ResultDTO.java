package com.example.retrofit_0.post;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class ResultDTO implements Serializable {
    @SerializedName("weaid")
    public String weaid;
    @SerializedName("days")
    public String days;
    @SerializedName("week")
    public String week;
    @SerializedName("cityno")
    public String cityno;
    @SerializedName("citynm")
    public String citynm;
    @SerializedName("cityid")
    public String cityid;
    @SerializedName("temperature")
    public String temperature;
    @SerializedName("humidity")
    public String humidity;
    @SerializedName("weather")
    public String weather;
    @SerializedName("weather_icon")
    public String weatherIcon;
    @SerializedName("weather_icon1")
    public String weatherIcon1;
    @SerializedName("wind")
    public String wind;
    @SerializedName("winp")
    public String winp;
    @SerializedName("temp_high")
    public String tempHigh;
    @SerializedName("temp_low")
    public String tempLow;
    @SerializedName("humi_high")
    public String humiHigh;
    @SerializedName("humi_low")
    public String humiLow;
    @SerializedName("weatid")
    public String weatid;
    @SerializedName("weatid1")
    public String weatid1;
    @SerializedName("windid")
    public String windid;
    @SerializedName("winpid")
    public String winpid;
    @SerializedName("weather_iconid")
    public String weatherIconid;
    @SerializedName("weather_iconid1")
    public String weatherIconid1;

    public static ResultDTO objectFromData(String str) {

        return new Gson().fromJson(str, ResultDTO.class);
    }
}
