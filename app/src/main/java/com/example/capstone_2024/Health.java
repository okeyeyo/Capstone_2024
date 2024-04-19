package com.example.capstone_2024;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Health extends AppCompatActivity {

    Button homebtn;
<<<<<<< HEAD
=======
    Button strechbtn;
    Button recvrbtn;
    Button musclebtn;
>>>>>>> bd7bd6e9beb14d36a18a1ad456cc319c74641742

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.health);

        homebtn = findViewById(R.id.home);
<<<<<<< HEAD
=======
        strechbtn = findViewById(R.id.streching);
        recvrbtn = findViewById(R.id.recovery);
        musclebtn = findViewById(R.id.muscle);
>>>>>>> bd7bd6e9beb14d36a18a1ad456cc319c74641742

        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomeActivity();
            }
        });
<<<<<<< HEAD
=======
        strechbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStrechingActivity();
            }
        });
        recvrbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRecoveryActivity();
            }
        });
        musclebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMuscleActivity();
            }
        });
>>>>>>> bd7bd6e9beb14d36a18a1ad456cc319c74641742
    }
    public void openHomeActivity() {
        Intent intent = new Intent(Health.this, MainActivity.class);
        startActivity(intent);
    }

    public void openStrechingActivity() {
        Intent intent = new Intent(Health.this, Streching.class);
        startActivity(intent);
    }
    public void openRecoveryActivity() {
        Intent intent = new Intent(Health.this,Recovery.class);
        startActivity(intent);
    }
    public void openMuscleActivity() {
        Intent intent = new Intent(Health.this, Muscle.class);
        startActivity(intent);
    }
}