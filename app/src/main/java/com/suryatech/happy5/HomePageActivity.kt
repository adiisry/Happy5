package com.suryatech.happy5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.ButterKnife
import com.suryatech.happy5.adapter.MovieAdapter
import com.suryatech.happy5.model.Response
import com.suryatech.happy5.model.ResultsItem
import com.suryatech.happy5.rest.ApiClient
import com.suryatech.happy5.rest.ApiInterface
import kotlinx.android.synthetic.main.activity_home_page.*
import retrofit2.Call
import retrofit2.Callback


class HomePageActivity : AppCompatActivity() {

    lateinit var Madapter: MovieAdapter
    var API_KEY: String = "7e8f60e325cd06e164799af1e317d7a7"
    var CATEGORY: String = "top_rated"
    var PAGE: Int = 1
    lateinit var recyclerView: RecyclerView
    lateinit var api: ApiClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
        ButterKnife.bind(this)

        recyclerView = rv_nowplaying
//        recyclerView.setHasFixedSize(true)
//        recyclerView.layoutManager = LinearLayoutManager(this)
        api = ApiClient()
        setupRecyclerView()
        CallRetrofit()

    }

    private fun setupRecyclerView() {
        Madapter = MovieAdapter(arrayListOf<ResultsItem>())
        recyclerView.apply {
            layoutManager = LinearLayoutManager (applicationContext)
            adapter = Madapter
        }
    }

    fun CallRetrofit() {
        val apiInterface: ApiInterface

        apiInterface = api.getClient()!!.create(ApiInterface::class.java)
        val call: Call<Response>
        call = apiInterface.getMovie(CATEGORY, API_KEY, PAGE)
        call.enqueue(object : Callback<Response> {
            override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {
                val mList: List<ResultsItem>
                mList = response.body()!!.results
                Madapter = MovieAdapter(mList)
                recyclerView.adapter
            }

            override fun onFailure(call: Call<Response>, t: Throwable) {

            }

        })
    }

}




