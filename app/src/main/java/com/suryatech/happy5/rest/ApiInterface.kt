package com.suryatech.happy5.rest



import com.suryatech.happy5.model.Response
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {
    @GET("/3/movie/{category}")
    fun getMovie(
            @Path("category")category: String,
            @Query("api_key")api_key: String,
            @Query("language")language: String,
            @Query("page")page: Int
    ): Call<Response>
}