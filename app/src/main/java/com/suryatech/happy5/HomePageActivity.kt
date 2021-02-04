package com.suryatech.happy5

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.ButterKnife
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.suryatech.happy5.R2.attr.layoutManager
import com.suryatech.happy5.adapter.MovieAdapter
import com.suryatech.happy5.model.MovieModel
import com.suryatech.happy5.service.ApiEndpoint
import kotlinx.android.synthetic.main.activity_home_page.*
import kotlinx.android.synthetic.main.adapter_movie.*
import org.json.JSONException
import org.json.JSONObject
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


class HomePageActivity : AppCompatActivity(), MovieAdapter.onSelectData {

    lateinit var movieAdapter: MovieAdapter
    private var moviePlayNow: MutableList<MovieModel> = ArrayList<MovieModel>()
    lateinit var api: ApiEndpoint

//    var imgCover: ImageView? = null
//    var imgPhoto:ImageView? = null
//    var rvTrailer: RecyclerView? = null
//    var imgFavorite: MaterialFavoriteButton? = null
//    var fabShare: FloatingActionButton? = null
//    var ratingBar: RatingBar? = null
//    var NameFilm: String? = null
//    var ReleaseDate:kotlin.String? = null
//    var Popularity:kotlin.String? = null
//    var Overview:kotlin.String? = null
//    var Cover:kotlin.String? = null
//    var Thumbnail:kotlin.String? = null
//    var movieURL:kotlin.String? = null
//    var Id = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
        ButterKnife.bind(this)

        var tvTitle = tv_title_home
        var tvRelease = tv_releasedate_home
        var tvOverview = tv_overview_home
        api = ApiEndpoint()


        val recyclerView = rv_nowplaying
        val manager = LinearLayoutManager(this)
        recyclerView.setLayoutManager(manager)
//        val adapter = movieAdapter
//        recyclerView.setAdapter(movieAdapter)
        rv_nowplaying.layoutManager = LinearLayoutManager(this)

        getMovie()
//        getPoster()
    }

//    private fun getMovie() {
//        AndroidNetworking.get("http://api.themoviedb.org/3/movie/top_rated?limit=3&api_key=7e8f60e325cd06e164799af1e317d7a7")
//                .setPriority(Priority.HIGH)
//                .build()
//                .getAsJSONObject(object : JSONObjectRequestListener {
//                    override fun onResponse(response: JSONObject) {
//                        try {
//                            val jsonArray = response.getJSONArray("results")
//                            for (i in 0 until jsonArray.length()){
//                                val jsonObject = jsonArray.getJSONObject(i)
//                                val dataApi = MovieModel()
//                                dataApi.setId(jsonObject.getInt("id"))
//                                tv_title_home.setText(jsonObject.getString("title"))
//                                tv_releasedate_home.setText(jsonObject.getString("release_date"))
//                            }
//                        } catch (e: JSONException) {
//                            e.printStackTrace()
//                            Toast.makeText((this@HomePageActivity), "Gagal menampilkan data!", Toast.LENGTH_SHORT).show()
//                        } catch (e: ParseException) {
//                            e.printStackTrace()
//                            Toast.makeText((this@HomePageActivity), "Gagal menampilkan data!", Toast.LENGTH_SHORT).show()
//                        }
//                    }
//
//                    override fun onError(anError: ANError?) {
//                        Toast.makeText((this@HomePageActivity), "Tidak ada jaringan internet!", Toast.LENGTH_SHORT).show()
//                        }
//                    })
//
//                }
//
//    private fun getPoster() {
//
//    }
//
//    override fun onSelected(modelMovie: MovieModel?) {
//
//    }
//}


//}


    private fun getMovie() {
        AndroidNetworking.get(ApiEndpoint.baseurl + ApiEndpoint.movie_nowplay + ApiEndpoint.apikey
                + ApiEndpoint.urlimage)
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONObject(object : JSONObjectRequestListener {
                    override fun onResponse(response: JSONObject) {
                        try {
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
                                moviePlayNow.add(dataApi)
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
        movieAdapter = MovieAdapter(this, moviePlayNow, this)
        rv_nowplaying.adapter = movieAdapter
        movieAdapter.notifyDataSetChanged()
    }

    override fun onSelected(modelMovie: MovieModel?) {

        val intent = Intent(this@HomePageActivity, DetailPageActivity::class.java)
        intent.putExtra("detailMovie", modelMovie)
        startActivity(intent)
    }
}



