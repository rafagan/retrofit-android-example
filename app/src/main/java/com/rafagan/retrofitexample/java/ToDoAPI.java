package com.rafagan.retrofitexample.java;

import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface ToDoAPI {
    @GET("todos")
    Call<List<ToDoDTO>> getToDos();
}
