package com.rafagan.retrofitexample.java;

import okhttp3.ResponseBody;

import java.util.List;

public class ToDoService extends BaseService<ToDoAPI> {
    public interface OnSuccess {
        void run(List<ToDoDTO> toDos);
    }

    public interface OnError {
        void run(ResponseBody errorBody);
    }

    public ToDoService(Class<ToDoAPI> toDoAPIClass) {
        super(toDoAPIClass);
    }

    @Override
    protected String getBaseUrl() {
        return "https://jsonplaceholder.typicode.com/";
    }

    public void getToDos(OnSuccess onSuccess, OnError onError) {

    }
}
