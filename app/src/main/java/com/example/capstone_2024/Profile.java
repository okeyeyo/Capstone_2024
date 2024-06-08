package com.example.capstone_2024;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class Profile extends AppCompatActivity {

    ImageButton homebtn;
    private EditText user_name, user_cm, user_kg;
    private RadioGroup gender;
    private RadioButton user_male, user_female;
    private Button savebtn, canclebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        homebtn = findViewById(R.id.home);
        user_name = findViewById(R.id.user_name);
        user_cm = findViewById(R.id.user_cm);
        user_kg = findViewById(R.id.user_kg);
        gender = findViewById(R.id.user_gender);
        user_male = findViewById(R.id.user_male);
        user_female = findViewById(R.id.user_female);
        savebtn = findViewById(R.id.user_save);
        canclebtn = findViewById(R.id.user_cancle);


        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomeActivity();
            }
        });

        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });

        canclebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    public void openHomeActivity() {
        Intent intent = new Intent(Profile.this, MainActivity.class);
        startActivity(intent);
    }

    private void saveData() {
        String name = user_name.getText().toString();
        String gender = user_male.isChecked() ? "남자" : "여자";
        String height = user_cm.getText().toString();
        String weight = user_kg.getText().toString();

        SharedPreferences sharedPreferences = getSharedPreferences("UserDara", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("이름", name);
        editor.putString("성별", gender);
        editor.putString("키", height);
        editor.putString("몸무게", weight);
        editor.apply();

        Intent intent = new Intent(Profile.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}