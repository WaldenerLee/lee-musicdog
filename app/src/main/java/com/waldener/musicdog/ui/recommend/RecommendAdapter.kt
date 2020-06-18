package com.waldener.musicdog.ui.recommend

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.waldener.musicdog.R
import com.waldener.musicdog.room.entity.RecordVideo
import kotlinx.android.synthetic.main.item_video.view.*

class RecommendAdapter : RecyclerView.Adapter<RecommendAdapter.RecommendViewHolder>() {
    private val list : MutableList<RecordVideo> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendViewHolder {
        val contentView: View = LayoutInflater.from(parent.context).inflate(R.layout.item_video, parent, false)
        return RecommendViewHolder(contentView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecommendViewHolder, position: Int) {
        val record = list[position]
        holder.itemView.tv_title.text = record.title
    }

    fun update(list: List<RecordVideo>?){
        this.list.clear()
        list?.let {
            this.list.addAll(it)
        }
        notifyDataSetChanged()
    }

    inner class RecommendViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}