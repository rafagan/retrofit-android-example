package com.rafagan.retrofitexample.kt

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


abstract class BaseService<T>(private val tClass: Class<T>) {
    private var service: T? = null
    protected abstract val baseUrl: String
    protected abstract val timeout: Int

    internal fun getService(): T? {
        if (service == null) {
            service = buildService()
        }
        return service
    }

    private fun buildService(): T {
        val service = Retrofit.Builder()

        val client = OkHttpClient.Builder()
        client.readTimeout(timeout.toLong(), TimeUnit.SECONDS)
        client.connectTimeout(timeout.toLong(), TimeUnit.SECONDS)

        service.client(client.build())
        service.baseUrl(baseUrl)
        service.addConverterFactory(GsonConverterFactory.create())

        return service.build().create(tClass)
    }
}