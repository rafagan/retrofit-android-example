package com.rafagan.retrofitexample.java;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class BaseService<T> {
    private Class<T> tClass;
    private T service;

    BaseService(Class<T> tClass) {
        this.tClass = tClass;
    }

    protected abstract String getBaseUrl();

    T getService() {
        if(service == null) {
            service = buildService();
        }
        return service;
    }

    private T buildService() {
        Retrofit.Builder service = new Retrofit.Builder();

        service.baseUrl(getBaseUrl());
        service.addConverterFactory(GsonConverterFactory.create());

        return service.build().create(tClass);
    }
}
