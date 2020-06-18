package com.waldener.musicdog.ui.recent

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.waldener.musicdog.room.AppDatabase
import com.waldener.musicdog.room.entity.Record

class RecentVM : ViewModel() {
    private val recordDao = AppDatabase.INSTANCE?.recordDao()

    internal fun getRecordLiveData(): LiveData<List<Record>>? {
        return recordDao?.getAll()
    }

    internal fun insert(record: Record) {
        Thread {
            recordDao?.insert(record)
        }.start()
    }

}