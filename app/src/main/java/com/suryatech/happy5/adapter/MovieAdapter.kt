package com.suryatech.happy5.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.suryatech.happy5.R
import com.suryatech.happy5.model.ResultsItem

class MovieAdapter(val resultList: List<ResultsItem>): RecyclerView.Adapter<MovieAdapter.MyViewHolder>() {

    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        context = parent.context
        val view = layoutInflater.inflate(R.layout.list_movie, parent, false)
        val viewHolder = MyViewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvTitle.setText(resultList.get(position).title)
        holder.tvOverview.setText(resultList.get(position).overview)
        Glide.with(context)
                .load("https://image.tmdb.org/t/p/w185" + resultList.get(position).posterPath)
                .into(holder.imgPoster)
    }

    override fun getItemCount(): Int = resultList.size

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPoster: ImageView = itemView.findViewById(R.id.iv_poster_image)
        val tvTitle: TextView = itemView.findViewById(R.id.tv_title_home)
        val tvOverview: TextView = itemView.findViewById(R.id.tv_overview_home)

    }

}