package com.suryatech.happy5.model

@Serializeble
class MovieModel() {

    private var Id = 0
    private var Title: String? = null
    private var Overview: String? = null
    private var ReleaseDate: String? = null
    private var PosterPath: String? = null
    private var BackdropPath: String? = null

    fun MovieModel() {}

    fun getId(): Int {
        return Id
    }

    fun setId(id: Int) {
        Id = id
    }

    fun getTitle(): String? {
        return Title
    }

    fun setTitle(title: String?) {
        Title = title
    }


    fun getOverview(): String? {
        return Overview
    }

    fun setOverview(overview: String?) {
        Overview = overview
    }

    fun getReleaseDate(): String? {
        return ReleaseDate
    }

    fun setReleaseDate(releaseDate: String?) {
        ReleaseDate = releaseDate
    }

    fun getPosterPath(): String? {
        return PosterPath
    }

    fun setPosterPath(posterPath: String?) {
        PosterPath = posterPath
    }

    fun getBackdropPath(): String? {
        return BackdropPath
    }

    fun setBackdropPath(backdropPath: String?) {
        BackdropPath = backdropPath
    }

}

annotation class Serializeble
