package com.example.capstone_2024;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Health extends AppCompatActivity{

    Button strechbtn;
    Button recvrbtn;
    Button musclebtn;
    Button homebtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.health);

        strechbtn = findViewById(R.id.streching);
        musclebtn = findViewById(R.id.muscle);
        homebtn = findViewById(R.id.home);

        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openhomeActivity();
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
    public void openhomeActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void openStrechingActivity() {
        Intent intent = new Intent(Health.this, Streching.class);
        startActivity(intent);
    }

    public void openMuscleActivity() {
        Intent intent = new Intent(Health.this, Muscle.class);
        startActivity(intent);
    }
}