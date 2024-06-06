package com.example.capstone_2024;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;


public class Health extends AppCompatActivity {

    ImageButton homebtn;
    Button strechbtn;
    Button musclebtn;
    ImageButton startbtn, resetbtn;
    Chronometer chronometer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.health);

        startbtn = findViewById(R.id._button1);
        resetbtn = findViewById(R.id._button2);

        homebtn = findViewById(R.id.home);
        strechbtn = findViewById(R.id.streching);
        musclebtn = findViewById(R.id.muscle);
        chronometer = (Chronometer) findViewById(R.id.timer);

        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.start();
            }
        });

        resetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.setBase(SystemClock.elapsedRealtime());
            }
        });

        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomeActivity();
            }
        });

        strechbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStrechingActivity();
            }
        });

        musclebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMuscleActivity();
            }
        });


    }

    public void openHomeActivity() {
        Intent intent = new Intent(Health.this, MainActivity.class);
        startActivity(intent);
    }

    public void openStrechingActivity() {
        Intent intent = new Intent(getApplicationContext(), Streching.class);
        startActivity(intent);
    }

    public void openMuscleActivity() {
        Intent intent = new Intent(Health.this, muscle_shoulder.class);
        startActivity(intent);
    }
}