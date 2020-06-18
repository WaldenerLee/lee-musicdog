package com.waldener.musicdog.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "record_video")
class RecordVideo(
    @ColumnInfo(name = "title") val title: String?
) {
    @PrimaryKey(autoGenerate = true) var id: Long = 0
    @ColumnInfo(name = "time") var time: Long = System.nanoTime()
}