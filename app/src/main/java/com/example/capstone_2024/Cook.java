package com.example.capstone_2024;

<<<<<<< HEAD
=======

>>>>>>> bd7bd6e9beb14d36a18a1ad456cc319c74641742
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

<<<<<<< HEAD
=======

>>>>>>> bd7bd6e9beb14d36a18a1ad456cc319c74641742
public class Cook extends AppCompatActivity {

    Button homebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cook);

        homebtn = findViewById(R.id.home);

        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomeActivity();
            }
        });
    }
    public void openHomeActivity() {
        Intent intent = new Intent(Cook.this, MainActivity.class);
        startActivity(intent);
    }
}

