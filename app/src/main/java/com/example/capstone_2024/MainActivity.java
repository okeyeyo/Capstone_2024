package com.example.capstone_2024;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button homebtn;
<<<<<<< HEAD
    Button cookbtn;
    Button healthbtn;
    Button setbtn;
=======
    Button profilebtn;
    Button cookbtn;
    Button healthbtn;
    Button starbtn;
>>>>>>> bd7bd6e9beb14d36a18a1ad456cc319c74641742

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homebtn = findViewById(R.id.home);
<<<<<<< HEAD
        cookbtn = findViewById(R.id.cook);
        healthbtn = findViewById(R.id.health);
        setbtn = findViewById(R.id.setting);
=======
        profilebtn = findViewById(R.id.profile);
        cookbtn = findViewById(R.id.cook);
        healthbtn = findViewById(R.id.health);
        starbtn = findViewById(R.id.setting);
>>>>>>> bd7bd6e9beb14d36a18a1ad456cc319c74641742

        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomeActivity();
            }
<<<<<<< HEAD
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

        setbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSetActivity();
            }
=======
>>>>>>> bd7bd6e9beb14d36a18a1ad456cc319c74641742
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
        Intent intent = new Intent(MainActivity.this, Cook.class);
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

    public void openSetActivity() {
        Intent intent = new Intent(MainActivity.this, Cook.class);
        startActivity(intent);
    }
}