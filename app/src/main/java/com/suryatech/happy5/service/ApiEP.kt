package com.suryatech.happy5.service

import com.suryatech.happy5.model.MovieModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiEP {

    @GET("top_rated?limit=3&api_key=7e8f60e325cd06e164799af1e317d7a7")
    fun getData(): Call<MovieModel>
}