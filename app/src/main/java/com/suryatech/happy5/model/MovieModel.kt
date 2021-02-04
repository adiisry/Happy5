package com.suryatech.happy5.model

import java.io.Serializable


class MovieModel : Serializable {
    var Id = 0
    lateinit var Title: String
    lateinit var Overview: String
    lateinit var ReleaseDate: String
    lateinit var PosterPath: String
    lateinit var BackdropPath: String

    fun MovieModel() {}

    @JvmName("getId1")
    public fun getId(): Int {
        return Id
    }

    @JvmName("setId1")
    public fun setId(id: Int) {
        var Id = id
    }


    @JvmName("getTitle1")
    public fun getTitle(): String {
        return Title
    }

    @JvmName("setTitle1")
    fun setTitle(title: String) {
        var Title = title
    }

    @JvmName("getOverview1")
    fun getOverview(): String {
        return Overview
    }

    @JvmName("setOverview1")
    fun setOverview(overview: String) {
        var Overview = overview
    }

    @JvmName("getReleaseDate1")
    fun getReleaseDate(): String {
        return ReleaseDate
    }

    @JvmName("setReleaseDate1")
    fun setReleaseDate(releaseDate: String) {
        var ReleaseDate = releaseDate
    }

    @JvmName("getPosterPath1")
    fun getPosterPath(): String {
        return PosterPath
    }

    @JvmName("setPosterPath1")
    fun setPosterPath(posterPath: String) {
        var PosterPath = posterPath
    }

    @JvmName("getBackdropPath1")
    fun getBackdropPath(): String {
        return BackdropPath
    }

    @JvmName("setBackdropPath1")
    fun setBackdropPath(backdropPath: String) {
        var BackdropPath = backdropPath
    }
}

//@Serializeble
//class MovieModel() {
//
//    private var Id = 0
//    private var Title: String? = null
//    private var Overview: String? = null
//    private var ReleaseDate: String? = null
//    private var PosterPath: String? = null
//    private var BackdropPath: String? = null
//
//    fun MovieModel() {}
//
//    fun getId(): Int {
//        return Id
//    }
//
//    fun setId(id: Int) {
//        Id = id
//    }
//
//    fun getTitle(): String? {
//        return Title
//    }
//
//    fun setTitle(title: String?) {
//        Title = title
//    }
//
//
//    fun getOverview(): String? {
//        return Overview
//    }
//
//    fun setOverview(overview: String?) {
//        Overview = overview
//    }
//
//    fun getReleaseDate(): String? {
//        return ReleaseDate
//    }
//
//    fun setReleaseDate(releaseDate: String?) {
//        ReleaseDate = releaseDate
//    }
//
//    fun getPosterPath(): String? {
//        return PosterPath
//    }
//
//    fun setPosterPath(posterPath: String?) {
//        PosterPath = posterPath
//    }
//
//    fun getBackdropPath(): String? {
//        return BackdropPath
//    }
//
//    fun setBackdropPath(backdropPath: String?) {
//        BackdropPath = backdropPath
//    }
//
//}
//
//annotation class Serializeble
