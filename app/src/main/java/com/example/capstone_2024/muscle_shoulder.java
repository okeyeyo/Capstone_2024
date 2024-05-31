package com.example.capstone_2024;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class muscle_shoulder extends AppCompatActivity {
    boolean display = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.muscle_main_shoulder);

        Muscle.listbtnset(this);
        Muscle.clickrebtn(this);
    }


}