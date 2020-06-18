package com.waldener.musicdog

import androidx.multidex.MultiDexApplication
import com.waldener.musicdog.room.AppDatabase

class MainApplication : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        AppDatabase.init(this)
    }

}