package com.waldener.musicdog.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Record")
data class Record(
    @PrimaryKey val id: Long,
    @ColumnInfo(name = "time") val time: Long?
)