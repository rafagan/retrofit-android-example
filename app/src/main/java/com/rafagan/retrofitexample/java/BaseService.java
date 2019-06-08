package com.rafagan.retrofitexample.java;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

public abstract class BaseService<T> {
    private Class<T> tClass;
    private T service;

    BaseService(Class<T> tClass) {
        this.tClass = tClass;
    }

    protected abstract String getBaseUrl();
    protected abstract int getTimeout();

    T getService() {
        if(service == null) {
            service = buildService();
        }
        return service;
    }

    private T buildService() {
        Retrofit.Builder service = new Retrofit.Builder();

        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.readTimeout(getTimeout(), TimeUnit.SECONDS);
        client.connectTimeout(getTimeout(), TimeUnit.SECONDS);

        service.client(client.build());
        service.baseUrl(getBaseUrl());
        service.addConverterFactory(GsonConverterFactory.create());

        return service.build().create(tClass);
    }
}
