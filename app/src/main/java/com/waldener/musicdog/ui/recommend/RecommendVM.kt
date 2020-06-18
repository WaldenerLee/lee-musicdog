package com.waldener.musicdog.ui.recommend

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.api.services.youtube.model.SearchListResponse
import com.waldener.musicdog.api.SearchApi

class RecommendVM : ViewModel() {

    internal val recommendLiveData = MutableLiveData<SearchListResponse?>()

    fun getRecommendList() {
        Thread {
            val searchResponse = SearchApi.search("张宇")
            recommendLiveData.postValue(searchResponse)
        }.start()
    }
}