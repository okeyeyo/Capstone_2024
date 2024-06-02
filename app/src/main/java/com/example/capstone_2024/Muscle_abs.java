package com.example.capstone_2024;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Muscle_abs extends AppCompatActivity {

    Button cablebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.muscle_main_abs);

        Muscle.listbtnset(this);
        Muscle.clickrebtn(this);

        cablebtn = findViewById(R.id.button_4);

        cablebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCableActivity();
            }
        });
    }
    public void openCableActivity() {
        Intent intent = new Intent(Muscle_abs.this, Muscle_abs_cable.class);
        startActivity(intent);
    }

}