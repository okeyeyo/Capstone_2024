package com.example.capstone_2024;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.function.DoubleToLongFunction;

public class MainActivity extends AppCompatActivity {

    ImageButton homebtn;
    ImageButton cookbtn;
   ImageButton healthbtn;
    LinearLayout profile;
    private TextView tv_name, tv_gender, tv_bmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homebtn = findViewById(R.id.home);
        cookbtn = findViewById(R.id.cook);
        healthbtn = findViewById(R.id.health);
        profile = findViewById(R.id.profile);
        tv_name = findViewById(R.id.name);
        tv_gender = findViewById(R.id.gender);
        tv_bmi = findViewById(R.id.bmi);

        loadData();

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
        Intent intent = new Intent(MainActivity.this, Cook_Recipe.class);
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

    private  void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE);
        String name = sharedPreferences.getString("name", "이름을 입력하세요");
        String gender = sharedPreferences.getString("gender", "성별을 고르세요");
        String height = sharedPreferences.getString("height", "0");
        String weight = sharedPreferences.getString("weight", "0");

        Log.d("MainActivity", "Loaded Data: Name = " + name + ", Gender = " + gender + ", Height = " + height + ", Weight = " + weight);

        double heightInMeters = Double.parseDouble(height) / 100;
        double weightInKg = Double.parseDouble(weight);
        double bmi = weightInKg / (heightInMeters * heightInMeters);

        tv_name.setText(name);
        tv_gender.setText(gender);
        tv_bmi.setText(String.format("%.2f",bmi));
    }

}