package com.waldener.musicdog.ui.player

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerFragment
import com.waldener.musicdog.R
import com.waldener.musicdog.api.ApiKey
import kotlinx.android.synthetic.main.fragment_player.*

class PlayerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_player, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val videoId = arguments?.getString("videoId")

//        val youTubePlayerFragment: YouTubePlayerFragment = childFragmentManager.findFragmentById(R.id.fragment_youtube) as YouTubePlayerFragment
//        youTubePlayerFragment.initialize(ApiKey.KEY, object : YouTubePlayer.OnInitializedListener{
//            override fun onInitializationSuccess(
//                provider: YouTubePlayer.Provider?,
//                player: YouTubePlayer?,
//                wasRestored: Boolean
//            ) {
//                player?.cueVideo(videoId)
//            }
//
//            override fun onInitializationFailure(
//                provider: YouTubePlayer.Provider?,
//                errorReason: YouTubeInitializationResult?
//            ) {
//                Log.i("PlayerFragment", "onInitializationFailure $provider, $errorReason")
//            }
//        })
//
//        childFragmentManager.beginTransaction().replace(R.id.fragment_container, YouTubePlayerFragment())
    }
}