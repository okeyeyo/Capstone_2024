package com.example.capstone_2024;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    Button cookbtn;
    Button healthbtn;
    LinearLayout profilebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cookbtn = findViewById(R.id.cook);
        healthbtn = findViewById(R.id.health);
        profilebtn = findViewById(R.id.profile);


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

        profilebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openprofilebtnActivity();
            }
        });
    }

    public void openCookActivity() {
        Intent intent = new Intent(MainActivity.this, Cook.class);
        startActivity(intent);
    }

    public void openHealthActivity() {
        Intent intent = new Intent(MainActivity.this, Health.class);
        startActivity(intent);
    }

    public void openprofilebtnActivity() {
        Intent intent = new Intent(MainActivity.this, Profile.class);
        startActivity(intent);
    }

}