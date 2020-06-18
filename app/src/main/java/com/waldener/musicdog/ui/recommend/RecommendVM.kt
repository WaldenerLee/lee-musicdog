package com.waldener.musicdog.ui.recommend

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.waldener.musicdog.room.entity.RecommendVideo

class RecommendVM : ViewModel() {

    internal val recommendLiveData = MutableLiveData<List<RecommendVideo>>()

    fun getRecommendList() {

    }
}