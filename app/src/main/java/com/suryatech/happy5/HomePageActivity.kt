package com.suryatech.happy5

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import com.suryatech.happy5.adapter.MovieAdapter
import com.suryatech.happy5.model.MovieModel
import com.suryatech.happy5.service.ApiEndpoint
import kotlinx.android.synthetic.main.activity_home_page.*
import org.json.JSONException
import org.json.JSONObject
import java.text.ParseException
import java.text.SimpleDateFormat


class HomePageActivity : AppCompatActivity() {

    val rv = rv_nowplaying
    var movieAdapter = MovieAdapter
    private val movieNowPlay: List<MovieModel> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
    }

    override fun onStart() {
        super.onStart()
//        setupRecyclerView()
//        getDataFromApi()
        getMovie()
    }

    private fun getMovie() {
        val api = ApiEndpoint()
        AndroidNetworking.get(api.BASEURL + api.APIKEY + api.MOVIE_NOWPLAY + api.URLIMAGE)
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONObject(object : JSONObjectRequestListener {
                    override fun onResponse(response: JSONObject) {
                        try {
//                            var movieNowPlay: ArrayList<> = null
                            val jsonArray = response.getJSONArray("results")
                            for (i in 0 until jsonArray.length()) {
                                val jsonObject = jsonArray.getJSONObject(i)
                                val dataApi = MovieModel()
                                val formatter = SimpleDateFormat("EEE, d MMMM yyyy")
                                val dateFormat = SimpleDateFormat("yyyy-mm-dd")
                                val datePost = jsonObject.getString("release_date")
                                dataApi.setId(jsonObject.getInt("id"))
                                dataApi.setTitle(jsonObject.getString("title"))
                                dataApi.setOverview(jsonObject.getString("overview"))
                                dataApi.setReleaseDate(formatter.format(dateFormat.parse(datePost)))
                                dataApi.setPosterPath(jsonObject.getString("poster_path"))
                                dataApi.setBackdropPath(jsonObject.getString("backdrop_path"))
//                                movieNowPlay.add(dataApi)
                                showMovie()
                            }
                        } catch (e: JSONException) {
                            e.printStackTrace()
                            Toast.makeText((this@HomePageActivity), "Gagal menampilkan data!", Toast.LENGTH_SHORT).show()
                        } catch (e: ParseException) {
                            e.printStackTrace()
                            Toast.makeText((this@HomePageActivity), "Gagal menampilkan data!", Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onError(anError: ANError) {
                        Toast.makeText((this@HomePageActivity), "Tidak ada jaringan internet!", Toast.LENGTH_SHORT).show()
                    }
                })
    }

    private fun showMovie() {
        movieAdapter = MovieAdapter
        rv_nowplaying.setAdapter(movieAdapter)
//        movieAdapter.setData()
    }

    fun onSelected(modelMovie: MovieModel) {
        var intent = Intent(this@HomePageActivity, DetailPageActivity::class.java)
//        intent.putExtra("detailMovie", modelMovie)
        startActivity(intent)
    }

    private fun RecyclerView.setAdapter(movieAdapter: MovieAdapter.Companion) {

    }

}

