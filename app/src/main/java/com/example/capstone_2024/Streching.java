package com.example.capstone_2024;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import org.jetbrains.annotations.NotNull;


public class Streching extends AppCompatActivity {



    Button[] btn = new Button[7];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.streching);


        Muscle.clickrebtn(this);
        int[] buttonIds = {
                R.id.button2,
                R.id.button3,
                R.id.button4,
                R.id.button5,
                R.id.button6,
                R.id.button7,
                R.id.button8
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
                ImageButton back;
              //  setContentView(R.layout.streching_list_neck);

                Intent intent = new Intent(getApplicationContext(), st_neck.class);
                startActivity(intent);
                back = findViewById(R.id.back);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), Streching.class);
                        startActivity(intent);
                    }
                });
            }
        });


        btn[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageButton back;
               // setContentView(R.layout.streching_list_shoulder);
                Intent intent = new Intent(getApplicationContext(), st_sho.class);

                startActivity(intent);
                back = findViewById(R.id.back);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), Streching.class);
                        startActivity(intent);
                    }
                });
            }
        });
        btn[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageButton back;
               // setContentView(R.layout.streching_list_back);
                Intent intent = new Intent(getApplicationContext(), st_back.class);

                startActivity(intent);

                back = findViewById(R.id.back);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), Streching.class);
                        startActivity(intent);
                    }
                });
            }
        });
        btn[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageButton back;
                //setContentView(R.layout.streching_list_wrist);

                Intent intent = new Intent(getApplicationContext(), st_wrist.class);
                startActivity(intent);
                back = findViewById(R.id.back);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), Streching.class);
                        startActivity(intent);
                    }
                });
            }
        });
        btn[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageButton back;
                //setContentView(R.layout.streching_list_ankle);
                Intent intent = new Intent(getApplicationContext(), st_ankle.class);
                back = findViewById(R.id.back);
                startActivity(intent);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), Streching.class);
                        startActivity(intent);


                    }
                });
            }
        });
        btn[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageButton back;
               // setContentView(R.layout.streching_list_waish);
                Intent intent = new Intent(getApplicationContext(), st_waish.class);
                startActivity(intent);

                back = findViewById(R.id.back);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), Streching.class);
                        startActivity(intent);
                    }
                });
            }
        });
        btn[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageButton back;
               // setContentView(R.layout.streching_list_knee);

                Intent intent = new Intent(getApplicationContext(), st_knee.class);
                startActivity(intent);



                back = findViewById(R.id.back);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), Streching.class);
                        startActivity(intent);
                    }
                });
            }
        });

    }

}