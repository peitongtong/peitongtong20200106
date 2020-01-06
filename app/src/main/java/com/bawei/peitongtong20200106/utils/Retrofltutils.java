package com.bawei.peitongtong20200106.utils;

import com.bawei.peitongtong20200106.api.Api;
import com.blankj.utilcode.util.NetworkUtils;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofltutils {
    private static Retrofltutils retrofltutils;
    private Retrofit retrofit;
    private Retrofltutils(){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
        retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static Retrofltutils getInstance(){
        if (retrofltutils==null){
            synchronized (Retrofltutils.class){
                if (retrofltutils==null){
                    retrofltutils = new Retrofltutils();
                }
            }
        }
        return  retrofltutils;
    }
    public <T>T createservice(Class<T> tClass){
        T t = retrofit.create(tClass);
        return t;
    }
    public boolean isNet(){
        return NetworkUtils.isConnected();
    }
}
