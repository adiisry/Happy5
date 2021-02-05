package com.suryatech.happy5.rest

import com.suryatech.happy5.service.ServiceConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


class ApiClient {
    val service = ServiceConfig()
    private val BASE_URL: String = service.API_ENDPOINT
    private var retrofit: Retrofit? = null
    fun getClient(): Retrofit? {
        if (retrofit == null) {
            retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        }
        return retrofit
    }
}