package com.waldener.musicdog.api

import android.util.Log

object SearchApi {

    private const val MAX_RESULTS = 20L

    fun search(queryTerm: String) {
        val youTube = YouTubeClient.getYouTube() ?: return
        val search = youTube.search()?.list(listOf("id,snippet")) ?: return
        search.key = ApiKey.KEY
        search.q = queryTerm
        search.type = listOf("video")
        search.fields = "items(id/kind,id/videoId,snippet/title,snippet/thumbnails/default/url)"
        search.maxResults = MAX_RESULTS

        val response = search.execute()
        Log.i("SearchApi", "response: $response")
        val list = response.items
    }
}