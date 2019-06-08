package com.rafagan.retrofitexample.kt

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


abstract class BaseService<T>(private val tClass: Class<T>) {
    private var service: T? = null
    abstract val baseUrl: String

    fun getService(): T? {
        if (service == null)
            service = buildService()
        return service
    }

    private fun buildService(): T {
        val service = Retrofit.Builder()

        service.baseUrl(baseUrl)
        service.addConverterFactory(GsonConverterFactory.create())

        return service.build().create(tClass)
    }
}