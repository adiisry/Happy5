package com.suryatech.happy5.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.suryatech.happy5.R
import com.suryatech.happy5.model.MovieModel
import kotlinx.android.synthetic.main.activity_detail_page.view.*
import kotlinx.android.synthetic.main.adapter_movie.view.*

class MovieAdapter(val results : ArrayList<MovieModel.Result>, val listener: OnAdapterListener)
    : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder (
        LayoutInflater.from( parent.context ).inflate( R.layout.adapter_movie, parent, false)
    )

    override fun getItemCount() = results.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val result = results[position]
        holder.view.tv_title_home.text = result.title
        holder.view.tv_genre.text = result.genres.toString()
        holder.view.tv_releasedate_home.text = result.release_date
        holder.view.tv_overview_home.text = result.overview
        Glide.with(holder.view)
            .load(result.poster_path)
            .centerCrop()
            .into(holder.view.iv_poster_image)
        holder.view.setOnClickListener {
            listener.onClick(result)
        }
        Glide.with(holder.view)
                .load(result.backdrop_path)
                .centerCrop()
                .into(holder.view.iv_bgposter)
    }

    class ViewHolder (val view: View) : RecyclerView.ViewHolder(view)

    fun setData(data: List<MovieModel.Result>) {
        results.clear()
        results.addAll(data)
        notifyDataSetChanged()
    }

    interface OnAdapterListener{
        fun onClick(result: MovieModel.Result)
    }
}