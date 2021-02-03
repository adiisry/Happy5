package com.suryatech.happy5.model

data class MovieModel(  val result: ArrayList<Result>) {
    data class Result ( val id: Int, val title: String, val genres: Int, val release_date: String, val overview: String, val poster_path: String, val backdrop_path: String )
}
