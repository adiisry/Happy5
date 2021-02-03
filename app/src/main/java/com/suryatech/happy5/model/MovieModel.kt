package com.suryatech.happy5.model

data class MovieModel(  val result: ArrayList<Result>) {
    data class Result ( val id: Int, val title: String, val releasedate: String, val overview:String, val image: String )
}
