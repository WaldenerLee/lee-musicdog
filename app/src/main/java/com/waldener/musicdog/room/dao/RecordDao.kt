package com.waldener.musicdog.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.waldener.musicdog.room.entity.RecordVideo

@Dao
interface RecordDao {

    @Query("SELECT * FROM record_video")
    fun getAll(): LiveData<List<RecordVideo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg recordVideos: RecordVideo)

    @Delete
    fun delete(vararg recordVideos: RecordVideo)

}