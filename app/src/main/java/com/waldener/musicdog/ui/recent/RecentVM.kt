package com.waldener.musicdog.ui.recent

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.waldener.musicdog.room.AppDatabase
import com.waldener.musicdog.room.entity.RecordVideo

class RecentVM : ViewModel() {
    private val recordDao = AppDatabase.INSTANCE?.recordDao()

    internal fun getRecordLiveData(): LiveData<List<RecordVideo>>? {
        return recordDao?.getAll()
    }

    internal fun insert(recordVideo: RecordVideo) {
        Thread {
            recordDao?.insert(recordVideo)
        }.start()
    }

}