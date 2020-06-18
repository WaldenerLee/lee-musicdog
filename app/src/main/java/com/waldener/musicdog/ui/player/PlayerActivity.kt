package com.waldener.musicdog.ui.player

import android.os.Bundle
import android.util.Log
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.waldener.musicdog.R
import com.waldener.musicdog.api.ApiKey
import kotlinx.android.synthetic.main.activity_player.*

class PlayerActivity : YouTubeBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)

        val videoId = intent.extras?.getString("videoId")
        Log.i("PlayerActivity", "videoId $videoId")

        youtube_view.initialize(ApiKey.KEY, object : YouTubePlayer.OnInitializedListener{
            override fun onInitializationSuccess(
                provider: YouTubePlayer.Provider?,
                player: YouTubePlayer?,
                wasRestored: Boolean
            ) {
                player?.cueVideo(videoId)
            }

            override fun onInitializationFailure(
                provider: YouTubePlayer.Provider?,
                errorReason: YouTubeInitializationResult?
            ) {
                Log.i("PlayerFragment", "onInitializationFailure $provider, $errorReason")
            }
        })
    }

}