package com.example.capstone_2024;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;


public class muscle_arm extends AppCompatActivity {

    android.widget.Button[] btn = new Button[5];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.muscle_main_arm);

        Muscle.listbtnset(this);
        Muscle.clickrebtn(this);

        int[] buttonIds = {
                R.id.button_2,
                R.id.button_3,
                R.id.button_4,
                R.id.button_5,
                R.id.button_6,
                R.id.button_7,
                R.id.button_8
        };

        for (int i = 0; i < btn.length; i++) {
            btn[i] = findViewById(buttonIds[i]);
        }

        btn_link_set();
    }

    public void btn_link_set(){


        btn[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                androidx.appcompat.widget.AppCompatButton back;
                setContentView(R.layout.muscle_youtube);

                TextView text;
                text = findViewById(R.id.arm_1);
                text.setVisibility(View.VISIBLE);

                YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view);
                youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
                    @Override
                    public void onReady(YouTubePlayer youTubePlayer) {
                        String videoId = "x731KYNsPBo"; // 여기에 재생할 YouTube 동영상의 ID를 입력
                        youTubePlayer.loadVideo(videoId, 0);
                        if(youTubePlayer!=null)
                            youTubePlayer.pause();
                    }
                });
                back = findViewById(R.id.back);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        text.setVisibility(View.INVISIBLE);
                        Intent intent = new Intent(getApplicationContext(), muscle_arm.class);
                        startActivity(intent);
                    }
                });
            }
        });
        btn[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                androidx.appcompat.widget.AppCompatButton back;
                setContentView(R.layout.muscle_youtube);

                TextView text;
                text = findViewById(R.id.arm_2);
                text.setVisibility(View.VISIBLE);

                YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view);
                youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
                    @Override
                    public void onReady(YouTubePlayer youTubePlayer) {
                        String videoId = "x731KYNsPBo"; // 여기에 재생할 YouTube 동영상의 ID를 입력
                        youTubePlayer.loadVideo(videoId, 0);
                    }
                });
                back = findViewById(R.id.back);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        text.setVisibility(View.INVISIBLE);
                        Intent intent = new Intent(getApplicationContext(), muscle_arm.class);
                        startActivity(intent);
                    }
                });
            }
        });
        btn[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                androidx.appcompat.widget.AppCompatButton back;
                setContentView(R.layout.muscle_youtube);

                TextView text;
                text = findViewById(R.id.arm_3);
                text.setVisibility(View.VISIBLE);

                YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view);
                youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
                    @Override
                    public void onReady(YouTubePlayer youTubePlayer) {
                        String videoId = "x731KYNsPBo"; // 여기에 재생할 YouTube 동영상의 ID를 입력
                        youTubePlayer.loadVideo(videoId, 0);
                    }
                });
                back = findViewById(R.id.back);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        text.setVisibility(View.INVISIBLE);
                        Intent intent = new Intent(getApplicationContext(), muscle_arm.class);
                        startActivity(intent);
                    }
                });
            }
        });
        btn[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                androidx.appcompat.widget.AppCompatButton back;
                setContentView(R.layout.muscle_youtube);
                TextView text;
                text = findViewById(R.id.arm_4);
                text.setVisibility(View.VISIBLE);


                YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view);
                youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
                    @Override
                    public void onReady(YouTubePlayer youTubePlayer) {
                        String videoId = "x731KYNsPBo"; // 여기에 재생할 YouTube 동영상의 ID를 입력
                        youTubePlayer.loadVideo(videoId, 0);
                    }
                });
                back = findViewById(R.id.back);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        text.setVisibility(View.INVISIBLE);
                        Intent intent = new Intent(getApplicationContext(), muscle_arm.class);
                        startActivity(intent);
                    }
                });
            }
        });
        btn[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                androidx.appcompat.widget.AppCompatButton back;
                setContentView(R.layout.muscle_youtube);

                TextView text;
                text = findViewById(R.id.arm_5);
                text.setVisibility(View.VISIBLE);

                YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view);
                youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
                    @Override
                    public void onReady(YouTubePlayer youTubePlayer) {
                        String videoId = "x731KYNsPBo"; // 여기에 재생할 YouTube 동영상의 ID를 입력
                        youTubePlayer.loadVideo(videoId, 0);
                    }
                });
                back = findViewById(R.id.back);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        text.setVisibility(View.INVISIBLE);
                        Intent intent = new Intent(getApplicationContext(), muscle_arm.class);
                        startActivity(intent);
                    }
                });
            }
        });
    }
}