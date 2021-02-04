package com.suryatech.happy5.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.suryatech.happy5.R
import com.suryatech.happy5.adapter.MovieAdapter.onSelectData
import com.suryatech.happy5.model.MovieModel
import com.suryatech.happy5.service.ApiEndpoint
import kotlinx.android.synthetic.main.activity_detail_page.view.*
import kotlinx.android.synthetic.main.adapter_movie.view.*


class MovieAdapter : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    private var items: List<MovieModel>? = null
    private var onSelectedData: MovieAdapter.onSelectData? = null
    private var mContext: Context? = null

    companion object {
        fun newInstance(): MovieAdapter = MovieAdapter()
    }

    interface onSelectData {
        fun onSelected(modelMovie: MovieModel?)
    }

    fun MovieAdapter(context: Context?, items: List<MovieModel>?, xSelectData: onSelectData?) {
        mContext = context
        this.items = items
        onSelectedData = xSelectData
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_movie, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("ResourceType")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data: MovieModel = items!![position]
        holder.tvTitle.setText(data.getTitle())
        holder.tvRealeseDate.setText(data.getReleaseDate())
        holder.tvDesc.setText(data.getOverview())
//        Glide.with(mContext!!)
//            .load(ApiEndpoint.URLIMAGE + data.getPosterPath())
//            .apply(
//                RequestOptions()
//                    .placeholder(R.id.iv_poster_image)
//                    .transform(RoundedCorners(16))
//            )
//            .into(holder.imgPhoto)
//        holder.cvFilm.setOnClickListener { onSelectedData!!.onSelected(data) }
    }

    override fun getItemCount(): Int {
        return items!!.size
    }


    fun setData(data: List<MovieModel>) {
        notifyDataSetChanged()
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var cvFilm: CardView
        var imgPhoto: ImageView
        var tvTitle: TextView
        var tvRealeseDate: TextView
        var tvDesc: TextView

        init {
            cvFilm = itemView.findViewById(R.id.cardView)
            imgPhoto = itemView.findViewById(R.id.iv_poster_image)
            tvTitle = itemView.findViewById(R.id.tv_title_home)
            tvRealeseDate = itemView.findViewById(R.id.tv_releasedate_home)
            tvDesc = itemView.findViewById(R.id.tv_overview_home)

            fun bindItem(holder: ViewHolder, api: ApiEndpoint, items: List<MovieModel>?, listener: (MovieModel) -> kotlin.Unit,
                context: Context
            ) {
                val data: MovieModel = items!![position]
                Glide.with(context)
                    .load(api.URLIMAGE + data.getPosterPath())
                    .into(holder.imgPhoto)
                holder.cvFilm.setOnClickListener { listener(MovieModel()) }
            }
        }

    }
}