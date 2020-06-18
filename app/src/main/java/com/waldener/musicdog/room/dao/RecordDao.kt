package com.waldener.musicdog.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.waldener.musicdog.room.entity.Record

@Dao
interface RecordDao {

    @Query("SELECT * FROM record")
    fun getAll(): LiveData<List<Record>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg records: Record)

    @Delete
    fun delete(vararg records: Record)

}