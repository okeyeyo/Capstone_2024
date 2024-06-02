package com.example.capstone_2024;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import org.jetbrains.annotations.NotNull;

public class Muscle_abs_cable extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.muscle_main_abs_cable);

        YouTubePlayerView youTubePlayerView = findViewById(R.id.muscle_abs_cable);
        getLifecycle().addObserver(youTubePlayerView);

        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
        @Override
            public void onReady(@NotNull YouTubePlayer youTubePlayer) {
            String videoId = "ObEtLS9heOo";
            youTubePlayer.loadVideo(videoId, 0);
        }
        });
    }
}


