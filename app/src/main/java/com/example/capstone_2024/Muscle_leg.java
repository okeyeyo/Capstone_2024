package com.example.capstone_2024;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;



public class Muscle_leg extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.muscle_main_leg);

        Muscle.listbtnset(this);
        Muscle.clickrebtn(this);
    }
}