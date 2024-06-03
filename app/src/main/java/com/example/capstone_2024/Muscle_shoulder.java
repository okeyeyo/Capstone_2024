package com.example.capstone_2024;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


public class Muscle_shoulder extends AppCompatActivity {
    boolean display = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.muscle_main_shoulder);

        Muscle.listbtnset(this);
        Muscle.clickrebtn(this);
    }


}