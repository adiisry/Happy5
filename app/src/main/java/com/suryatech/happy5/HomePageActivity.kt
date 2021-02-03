package com.suryatech.happy5

import android.app.ProgressDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.suryatech.happy5.adapter.MovieAdapter
import com.suryatech.happy5.model.MovieModel
import kotlinx.android.synthetic.main.activity_home_page.*


class HomePageActivity : AppCompatActivity() {

    val rv = rv_nowplaying
//    val movieAdapter = MovieAdapter
    private val movieNowPlay: List<MovieModel> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
    }

    override fun onStart() {
        super.onStart()
//        setupRecyclerView()
//        getDataFromApi()
    }


}