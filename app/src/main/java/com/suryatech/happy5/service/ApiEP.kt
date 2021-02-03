package com.suryatech.happy5.service

import com.suryatech.happy5.model.MovieModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiEP {

    @GET("")
    fun getData(): Call<MovieModel>
}