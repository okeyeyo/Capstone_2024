package com.example.capstone_2024;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;



public class Muscle extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.muscle_main_back);

    }

    public static void listbtnset(final Activity activity){

        android.widget.Button backbtn, chestbtn,shobtn, armbtn, legbtn,absbtn,rebtn;
        rebtn = activity.findViewById(R.id.back);
        backbtn = activity.findViewById(R.id.backbtn);
        chestbtn = activity.findViewById(R.id.chestbtn);
        shobtn = activity.findViewById(R.id.shobtn);
        legbtn = activity.findViewById(R.id.legbtn);
        absbtn = activity.findViewById(R.id.absbtn);
        armbtn = activity.findViewById(R.id.armbtn);

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, Muscle_back.class);
                activity.startActivity(intent);
            }
        });

        shobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, Muscle_shoulder.class);
                activity.startActivity(intent);
            }
        });

        armbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, Muscle_arm.class);
                activity.startActivity(intent);
            }
        });
        chestbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, Muscle_chest.class);
                activity.startActivity(intent);
            }
        });
        legbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, Muscle_leg.class);
                activity.startActivity(intent);
            }
        });
        absbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, Muscle_abs.class);
                activity.startActivity(intent);
            }
        });
    }

    public static void clickrebtn(Activity activity){
        android.widget.Button rebtn;
        rebtn = activity.findViewById(R.id.back);
        rebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, Health.class);
                activity.startActivity(intent);
            }
        });
    }
}