package com.rafagan.retrofitexample.java;

import okhttp3.ResponseBody;

import java.util.List;

public class ToDoService extends BaseService<ToDoAPI> {
    public ToDoService(Class<ToDoAPI> toDoAPIClass) {
        super(toDoAPIClass);
    }

    @Override
    protected String getBaseUrl() {
        return "https://jsonplaceholder.typicode.com/";
    }

    public void getToDos(DefaultCallback.OnSuccess<List<ToDoDTO>> onSuccess, DefaultCallback.OnError onError) {

    }
}
