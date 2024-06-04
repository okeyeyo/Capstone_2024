package com.example.capstone_2024;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    ImageButton homebtn;
    ImageButton cookbtn;
    ImageButton healthbtn;
    LinearLayout profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homebtn = findViewById(R.id.home);
        cookbtn = findViewById(R.id.cook);
        healthbtn = findViewById(R.id.health);
        profile = findViewById(R.id.profile);

        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomeActivity();
            }
        });

        cookbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCookActivity();
            }
        });

        healthbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHealthActivity();
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProfileActivity();
            }
        });

    }
    public void openHomeActivity() {
        Intent intent = new Intent(MainActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void openCookActivity() {
        Intent intent = new Intent(MainActivity.this, Cook.class);
        startActivity(intent);
    }

    public void openHealthActivity() {
        Intent intent = new Intent(MainActivity.this, Health.class);
        startActivity(intent);
    }

    public void openProfileActivity() {
        Intent intent = new Intent(MainActivity.this, Profile.class);
        startActivity(intent);
    }

}