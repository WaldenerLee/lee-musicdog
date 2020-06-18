package com.waldener.musicdog.api

import com.google.api.client.googleapis.json.GoogleJsonResponseException
import com.google.api.client.http.HttpRequestInitializer
import com.google.api.client.http.javanet.NetHttpTransport
import com.google.api.client.json.jackson2.JacksonFactory
import com.google.api.services.youtube.YouTube
import java.io.IOException
import java.lang.Exception

object YouTubeClient {

    private const val appName = "Lee-Music"

    private val HTTP_TRANSPORT = NetHttpTransport()

    private val JSON_FACTORY = JacksonFactory()

    fun getYouTube(): YouTube? {
        try {
            // This object is used to make YouTube Data API requests. The last
            // argument is required, but since we don't need anything
            // initialized when the HttpRequest is initialized, we override
            // the interface and provide a no-op function.
            return YouTube.Builder(
                HTTP_TRANSPORT,
                JSON_FACTORY,
                HttpRequestInitializer {}
            ).setApplicationName(appName)
                .build()
        } catch (e: GoogleJsonResponseException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }
}