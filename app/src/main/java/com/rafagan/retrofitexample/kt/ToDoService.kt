package com.rafagan.retrofitexample.kt

import okhttp3.ResponseBody

class ToDoService: BaseService<ToDoAPI>(ToDoAPI::class.java) {
    override val baseUrl: String
        get() = "https://jsonplaceholder.typicode.com/"

    fun getToDos(onSuccess: (List<ToDoDTO>?) -> Unit, onError: (ResponseBody?) -> Unit) {
        val caller = getService()?.getToDos()
        caller?.enqueue(DefaultCallback(onSuccess, onError))
    }
}