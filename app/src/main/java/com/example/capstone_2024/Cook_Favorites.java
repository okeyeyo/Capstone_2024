package com.example.capstone_2024;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Cook_Favorites extends AppCompatActivity {

    ImageButton homebtn;
    Button ingredientbtn;
    Button recipebtn;
    Button favoritesbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cook_favorites);

        homebtn = findViewById(R.id.home);
        ingredientbtn = findViewById(R.id.ingredient);
        recipebtn = findViewById(R.id.recipe);
        favoritesbtn = findViewById(R.id.favorites);

        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomeActivity();
            }
        });

        ingredientbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openIngredientActivity();
            }
        });

        recipebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRecipeActivity();
            }
        });

        favoritesbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFavoritesActivity();
            }
        });
    }
    public void openHomeActivity() {
        Intent intent = new Intent(Cook_Favorites.this, MainActivity.class);
        startActivity(intent);
    }
    public void openIngredientActivity() {
        Intent intent = new Intent(Cook_Favorites.this, Cook_Ingredient.class);
        startActivity(intent);
    }
    public void openRecipeActivity() {
        Intent intent = new Intent(Cook_Favorites.this, Cook_Recipe.class);
        startActivity(intent);
    }
    public void openFavoritesActivity() {
        Intent intent = new Intent(Cook_Favorites.this, Cook_Favorites.class);
        startActivity(intent);
    }
}
