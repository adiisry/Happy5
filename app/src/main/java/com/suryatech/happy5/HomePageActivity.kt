package com.suryatech.happy5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_home_page.*
import com.suryatech.happy5.adapter.MovieAdapter
import com.suryatech.happy5.model.MovieModel
import com.suryatech.happy5.service.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomePageActivity : AppCompatActivity() {
    private val TAG: String = "HomePage"
    lateinit var movieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
    }

    override fun onStart() {
        super.onStart()
        setupRecyclerView()
        getDataFromApi()
    }

    private fun setupRecyclerView(){
        movieAdapter = MovieAdapter(arrayListOf(), object : MovieAdapter.OnAdapterListener {
            override fun onClick(result: MovieModel.Result) {
                startActivity(Intent(applicationContext,DetailPageActivity::class.java)
                        .putExtra("intent_title", result.title)
                        .putExtra("intent_poster_path", result.poster_path)
                        .putExtra("intent_overview", result.overview)
                )
            }
        })
        rv_nowplaying.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = movieAdapter
        }
    }

    private fun getDataFromApi(){

        ApiService.endpoint.getData()
                .enqueue(object : Callback<MovieModel> {
                    override fun onResponse(
                            call: Call<MovieModel>,
                            response: Response<MovieModel>
                    ) {
                        if (response.isSuccessful){
                            showData(response.body()!!)
                        }
                    }

                    override fun onFailure(call: Call<MovieModel>, t: Throwable) {
                        printLog( "onFailure: $t" )
                    }

                })

    }

    private fun printLog(message: String) {
        Log.d(TAG, message)
    }

    private fun showData(data: MovieModel){
        val results= data.result
        movieAdapter.setData(results)
    }

}