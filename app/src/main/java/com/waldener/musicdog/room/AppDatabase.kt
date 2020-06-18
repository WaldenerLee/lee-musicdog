package com.waldener.musicdog.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.waldener.musicdog.room.dao.RecordDao
import com.waldener.musicdog.room.entity.RecordVideo

@Database(entities = [RecordVideo::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        var INSTANCE: AppDatabase? = null

        fun init(context: Context) {
            if(INSTANCE == null){
                INSTANCE = Room.databaseBuilder(context, AppDatabase::class.java, "database.db").build()
            }
        }
    }

    abstract fun recordDao(): RecordDao

}