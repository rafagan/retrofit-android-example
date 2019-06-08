package com.rafagan.retrofitexample.java;

import retrofit2.Call;

import java.util.List;

public class ToDoService extends BaseService<ToDoAPI> {
    public ToDoService() {
        super(ToDoAPI.class);
    }

    @Override
    protected String getBaseUrl() {
        return "https://jsonplaceholder.typicode.com/";
    }

    public void getToDos(DefaultCallback.OnSuccess<List<ToDoDTO>> onSuccess, DefaultCallback.OnError onError) {
        Call<List<ToDoDTO>> caller = getService().getToDos();
        caller.enqueue(new DefaultCallback<>(onSuccess, onError));
    }
}
