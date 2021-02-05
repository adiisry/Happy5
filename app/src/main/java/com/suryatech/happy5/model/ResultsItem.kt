package com.suryatech.happy5.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class ResultsItem(

        @field:Expose
        @field:SerializedName("overview")
        val overview: String,

        @field:Expose
        @field:SerializedName("original_language")
        val originalLanguage: String,

        @field:Expose
        @field:SerializedName("original_title")
        val originalTitle: String,

        @field:Expose
        @field:SerializedName("video")
        val video: Boolean,

        @field:Expose
        @field:SerializedName("title")
        val title: String,

        @field:Expose
        @field:SerializedName("genre_ids")
        val genreIds: List<Int>,

        @field:Expose
        @field:SerializedName("poster_path")
        val posterPath: String,

        @field:Expose
        @field:SerializedName("backdrop_path")
        val backdropPath: String,

        @field:Expose
        @field:SerializedName("release_date")
        val releaseDate: String,

        @field:Expose
        @field:SerializedName("popularity")
        val popularity: Double,

        @field:Expose
        @field:SerializedName("vote_average")
        val voteAverage: Int,

        @field:Expose
        @field:SerializedName("id")
        val id: Int,

        @field:Expose
        @field:SerializedName("adult")
        val adult: Boolean,

        @field:Expose
        @field:SerializedName("vote_count")
        val voteCount: Int
)