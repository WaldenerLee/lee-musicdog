package com.waldener.musicdog.ui.recent

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.waldener.musicdog.R
import com.waldener.musicdog.room.entity.Record
import kotlinx.android.synthetic.main.item_record.view.*

class RecentAdapter : RecyclerView.Adapter<RecentAdapter.RecentViewHolder>() {
    private val list : MutableList<Record> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecentViewHolder {
        val contentView: View = LayoutInflater.from(parent.context).inflate(R.layout.item_record, parent, false)
        return RecentViewHolder(contentView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecentViewHolder, position: Int) {
        val record = list[position]
        holder.itemView.tv_title.text = record.title
    }

    fun update(list: List<Record>?){
        list?.let {
            this.list.clear()
            this.list.addAll(it)
            notifyDataSetChanged()
        }
    }

    inner class RecentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}