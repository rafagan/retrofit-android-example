package com.rafagan.retrofitexample.kt

import retrofit2.Retrofit


abstract class BaseService<T>(private val tClass: Class<T>) {
    private var service: T? = null
    abstract val baseUrl: String

    fun getService(): T? {
        if (service == null)
            service = buildService()
        return service
    }

    private fun buildService(): T {
        val service = Retrofit.Builder().baseUrl(baseUrl)
        return service.build().create(tClass)
    }
}