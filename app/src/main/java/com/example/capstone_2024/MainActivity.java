package com.example.capstone_2024;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    Button homebtn;
    LinearLayout profilebtn;
    Button cookbtn;
    Button healthbtn;
    Button starbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homebtn = findViewById(R.id.home);
        profilebtn = findViewById(R.id.profile);
        cookbtn = findViewById(R.id.cook);
        healthbtn = findViewById(R.id.health);
        starbtn = findViewById(R.id.setting);

        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomeActivity();
            }
        });

        profilebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {openProfileActivity();}
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

        starbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSetActivity();
            }
        });


    }
    public void openHomeActivity() {
        Intent intent = new Intent(MainActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void openProfileActivity() {
        Intent intent = new Intent(MainActivity.this, Profile.class);
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

    public void openSetActivity() {
        Intent intent = new Intent(MainActivity.this, Cook.class);
        startActivity(intent);
    }
}