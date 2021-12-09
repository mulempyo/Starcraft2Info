package org.techtown.starcraft2

import android.os.Bundle
import android.widget.Toast
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import org.techtown.starcraft2.databinding.NewsBinding



class NewsActivity : YouTubeBaseActivity() {
     val binding by lazy { NewsBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.youTubePlayerView.initialize(getString(R.string.api_key), object : YouTubePlayer.OnInitializedListener {
            override fun onInitializationSuccess(p0: YouTubePlayer.Provider?, p1: YouTubePlayer?, p2: Boolean) {
                p1?.loadPlaylist("PLLquYTNjGF70OtOTJGg8dl5zbv7BOS5gB")
                p1?.play()
            }

            override fun onInitializationFailure(p0: YouTubePlayer.Provider?, p1: YouTubeInitializationResult?) {
                Toast.makeText(applicationContext, "에러발생", Toast.LENGTH_LONG).show()
            }
        })
    }
}