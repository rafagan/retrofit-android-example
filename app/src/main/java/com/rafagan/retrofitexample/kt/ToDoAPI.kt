package com.rafagan.retrofitexample.kt

import retrofit2.Call
import retrofit2.http.GET

interface ToDoAPI {
    @GET("todos")
    fun getToDos(): Call<List<ToDoDTO>>
}