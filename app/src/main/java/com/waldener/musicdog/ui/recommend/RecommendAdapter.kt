package com.waldener.musicdog.ui.recommend

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.api.services.youtube.model.SearchResult
import com.waldener.musicdog.R
import kotlinx.android.synthetic.main.item_video.view.*

class RecommendAdapter : RecyclerView.Adapter<RecommendAdapter.RecommendViewHolder>() {
    private val list : MutableList<SearchResult> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendViewHolder {
        val contentView: View = LayoutInflater.from(parent.context).inflate(R.layout.item_video, parent, false)
        return RecommendViewHolder(contentView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecommendViewHolder, position: Int) {
        val searchResult = list[position]
        holder.itemView.tv_title.text = searchResult.snippet?.title
        holder.itemView.tv_channel.text = searchResult.snippet?.channelTitle
        Glide.with(holder.itemView).load(searchResult.snippet.thumbnails.high.url).into(holder.itemView.iv_thumbnail)

        holder.itemView.setOnClickListener {
            val bundle = bundleOf("videoId" to searchResult.id.videoId)
            Navigation.findNavController(it).navigate(R.id.home_to_player, bundle)
        }
    }

    fun update(list: List<SearchResult>?){
        this.list.clear()
        list?.let {
            this.list.addAll(it)
        }
        notifyDataSetChanged()
    }

    inner class RecommendViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}