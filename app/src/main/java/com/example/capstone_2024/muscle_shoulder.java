package com.example.capstone_2024;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.Stack;


public class muscle_shoulder extends AppCompatActivity {
    boolean display = true;
    //android.widget.Button[] btn = new Button[7];
    androidx.appcompat.widget.AppCompatButton[] btn = new AppCompatButton[7];


    Stack<Integer> layoutStack = new Stack<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.muscle_main_shoulder);


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
        int[] buttonIds2 = {
                R.id.shoul_1,
                R.id.shoul_2,
                R.id.shoul_3,
                R.id.shoul_4,
                R.id.shoul_5,
                R.id.shoul_6,
                R.id.shoul_7
        };

        for (int i = 0; i < btn.length; i++) {
            btn[i] = findViewById(buttonIds[i]);

        }

        btn_link_set();


        ImageButton home = findViewById(R.id.home);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

            }
        });


    }






    // 버튼이름과 맞는 운동 영상 출력
    public void btn_link_set(){

        btn[0].setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                TextView text2;
                androidx.appcompat.widget.AppCompatButton back;
                setContentView(R.layout.muscle_youtube);
                TextView text;
                text = findViewById(R.id.shoul_1);

                text.setVisibility(View.VISIBLE);
                ImageButton home = findViewById(R.id.home);

                home.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);

                    }
                });

                YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view);
                youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
                    @Override
                    public void onReady(YouTubePlayer youTubePlayer) {
                        String videoId = "lpc1P_zj3XI"; // 여기에 재생할 YouTube 동영상의 ID를 입력
                        youTubePlayer.loadVideo(videoId, 0);
                    }
                });


                back = findViewById(R.id.back);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        text.setVisibility(View.INVISIBLE);
                        Intent intent = new Intent(getApplicationContext(), muscle_shoulder.class);
                        startActivity(intent);


                    }
                });


            }
        });
        btn[1].setOnClickListener(new View.OnClickListener() {
            TextView text2;
            androidx.appcompat.widget.AppCompatButton back;
            @Override
            public void onClick(View v) {



                setContentView(R.layout.muscle_youtube);
                text2 = findViewById(R.id.shoul_2);
                ImageButton home = findViewById(R.id.home);

                home.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);

                    }
                });

                text2.setVisibility(View.VISIBLE);
                YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view);
                youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
                    @Override
                    public void onReady(YouTubePlayer youTubePlayer) {
                        String videoId = "Q7hSueKPHpM"; // 여기에 재생할 YouTube 동영상의 ID를 입력
                        youTubePlayer.loadVideo(videoId, 0);
                    }
                });



                back = findViewById(R.id.back);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        text2.setVisibility(View.INVISIBLE);
                        Intent intent = new Intent(getApplicationContext(), muscle_shoulder.class);
                        startActivity(intent);
                    }
                });
            }
        });
        btn[2].setOnClickListener(new View.OnClickListener() {
            TextView text3;
            androidx.appcompat.widget.AppCompatButton back;
            @Override
            public void onClick(View v) {
                ImageButton home = findViewById(R.id.home);

                home.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);

                    }
                });


                setContentView(R.layout.muscle_youtube);
                text3 = findViewById(R.id.shoul_3);

                text3.setVisibility(View.VISIBLE);
                YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view);
                youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
                    @Override
                    public void onReady(YouTubePlayer youTubePlayer) {
                        String videoId = "66gDfjrm-gk"; // 여기에 재생할 YouTube 동영상의 ID를 입력
                        youTubePlayer.loadVideo(videoId, 0);
                    }
                });

                back = findViewById(R.id.back);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        text3.setVisibility(View.INVISIBLE);
                        Intent intent = new Intent(getApplicationContext(), muscle_shoulder.class);
                        startActivity(intent);
                    }
                });
            }
        });
        btn[3].setOnClickListener(new View.OnClickListener() {
            androidx.appcompat.widget.AppCompatButton back;
            @Override
            public void onClick(View v) {
                setContentView(R.layout.muscle_youtube);
                TextView text;
                text = findViewById(R.id.shoul_4);
                ImageButton home = findViewById(R.id.home);

                home.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);

                    }
                });

                text.setVisibility(View.VISIBLE);
                YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view);
                youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
                    @Override
                    public void onReady(YouTubePlayer youTubePlayer) {
                        String videoId = "sRWFEY1M_Jo"; // 여기에 재생할 YouTube 동영상의 ID를 입력
                        youTubePlayer.loadVideo(videoId, 0);
                    }
                });
                back = findViewById(R.id.back);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        text.setVisibility(View.INVISIBLE);
                        Intent intent = new Intent(getApplicationContext(), muscle_shoulder.class);
                        startActivity(intent);
                    }
                });
            }
        });
        btn[4].setOnClickListener(new View.OnClickListener() {
            androidx.appcompat.widget.AppCompatButton back;
            @Override
            public void onClick(View v) {
                setContentView(R.layout.muscle_youtube);
                TextView text;
                text = findViewById(R.id.shoul_5);
                ImageButton home = findViewById(R.id.home);

                home.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);

                    }
                });

                text.setVisibility(View.VISIBLE);
                YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view);
                youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
                    @Override
                    public void onReady(YouTubePlayer youTubePlayer) {
                        String videoId = "YdhHnZxcpgY"; // 여기에 재생할 YouTube 동영상의 ID를 입력
                        youTubePlayer.loadVideo(videoId, 0);
                    }
                });
                back = findViewById(R.id.back);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        text.setVisibility(View.INVISIBLE);
                        Intent intent = new Intent(getApplicationContext(), muscle_shoulder.class);
                        startActivity(intent);
                    }
                });
            }
        });
        btn[5].setOnClickListener(new View.OnClickListener() {
            androidx.appcompat.widget.AppCompatButton back;
            @Override
            public void onClick(View v) {
                setContentView(R.layout.muscle_youtube);
                TextView text;
                text = findViewById(R.id.shoul_6);
                ImageButton home = findViewById(R.id.home);

                home.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);

                    }
                });

                text.setVisibility(View.VISIBLE);
                YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view);
                youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
                    @Override
                    public void onReady(YouTubePlayer youTubePlayer) {
                        String videoId = "iD4r-e8mmj8"; // 여기에 재생할 YouTube 동영상의 ID를 입력
                        youTubePlayer.loadVideo(videoId, 0);
                    }
                });
                back = findViewById(R.id.back);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        text.setVisibility(View.INVISIBLE);
                        Intent intent = new Intent(getApplicationContext(), muscle_shoulder.class);
                        startActivity(intent);
                    }
                });
            }
        });

        btn[6].setOnClickListener(new View.OnClickListener() {
            androidx.appcompat.widget.AppCompatButton back;
            @Override
            public void onClick(View v) {
                setContentView(R.layout.muscle_youtube);
                TextView text;
                text = findViewById(R.id.shoul_7);
                ImageButton home = findViewById(R.id.home);

                home.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);

                    }
                });

                text.setVisibility(View.VISIBLE);
                YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view);
                youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
                    @Override
                    public void onReady(YouTubePlayer youTubePlayer) {
                        String videoId = "ylMZB3dtEgs"; // 여기에 재생할 YouTube 동영상의 ID를 입력
                        youTubePlayer.loadVideo(videoId, 0);
                    }
                });
                back = findViewById(R.id.back);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        text.setVisibility(View.INVISIBLE);
                        Intent intent = new Intent(getApplicationContext(), muscle_shoulder.class);
                        startActivity(intent);
                    }
                });
            }
        });

    }

}