package com.example.capstone_2024;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Muscle extends AppCompatActivity {
    boolean display = true;
    Button rebtn;
    android.widget.Button backbtn, chestbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.muscle_main_shoulder);

        rebtn = findViewById(R.id.back);
        backbtn = findViewById(R.id.backbtn);
        chestbtn = findViewById(R.id.chestbtn);

        chestbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    setContentView(R.layout.muscle_main_shoulder);

            }
        });
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                  setContentView(R.layout.muscle_main_back);

            }
        });
        rebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomeActivity();
            }
        });
    }
    public void openHomeActivity() {
        Intent intent = new Intent(Muscle.this, Health.class);
        startActivity(intent);
    }

}