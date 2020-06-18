package com.waldener.musicdog.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recommend_video")
class RecommendVideo(
    val title: String?
){
    @PrimaryKey(autoGenerate = true) var id: Long = 0
}