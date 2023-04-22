package com.example.retrofit_0.post;

import retrofit2.http.Field;

public class bodytext {
    private String app;
    private String weaid;
    private String appkey;
    private String sign;
    private String format;

    public bodytext(String app,String weaid,String appkey,String sign,String format) {
        this.app = app;
        this.appkey = appkey;
        this.format = format;
        this.sign = sign;
        this.weaid = weaid;
    }
}
