package com.waldener.musicdog.api

import android.util.Log
import com.google.api.services.youtube.model.SearchListResponse

object SearchApi {

    private const val MAX_RESULTS = 25L

    fun search(queryTerm: String): SearchListResponse? {
        val youTube = YouTubeClient.getYouTube() ?: return null
        val search = youTube.search()?.list(listOf("id,snippet")) ?: return null
        search.key = ApiKey.KEY
        search.q = queryTerm
        search.type = listOf("video")
//        search.fields = "items(id/kind,id/videoId,snippet/title,snippet/thumbnails/default/url)"
        search.maxResults = MAX_RESULTS

        val response = search.execute()
        Log.i("SearchApi", "response: $response")
        return response
    }
}