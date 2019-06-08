package com.rafagan.retrofitexample.kt

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response

open class DefaultCallback<T>(
    val onSuccess: (T?) -> Unit,
    val onError: (ResponseBody?) -> Unit) : retrofit2.Callback<T>
{
    override fun onFailure(call: Call<T>, t: Throwable) {
        t.printStackTrace()
    }

    override fun onResponse(call: Call<T>, response: Response<T>) {
        if(response.isSuccessful) {
            onSuccess(response.body())
        } else {
            onError(response.errorBody())
        }
    }
}