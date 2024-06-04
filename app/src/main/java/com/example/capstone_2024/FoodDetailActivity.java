package com.example.capstone_2024;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class FoodDetailActivity extends AppCompatActivity {

    ImageButton homebtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_detail);

        homebtn = findViewById(R.id.home);

        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomeActivity();
            }
        });

        TextView foodNameTextView = findViewById(R.id.foodNameTextView);
        TextView ingredientsTextView = findViewById(R.id.ingredientsTextView);
        TextView manual1TextView = findViewById(R.id.manual1TextView);
        ImageView manual_img1TextView = findViewById(R.id.manual_img1TextView);

        Intent intent = getIntent();
        String foodName = intent.getStringExtra("foodName");
        String ingredients = intent.getStringExtra("ingredients");
        String manual1 = intent.getStringExtra("manual1");
        String manual_img1  = intent.getStringExtra("manual_img1");

        foodNameTextView.setText(foodName);
        ingredientsTextView.setText(ingredients);
        manual1TextView.setText(manual1);
        Picasso.get().load(manual_img1).into(manual_img1TextView);
    }

    public void openHomeActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}

