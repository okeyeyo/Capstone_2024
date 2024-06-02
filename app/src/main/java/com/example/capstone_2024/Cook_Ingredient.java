package com.example.capstone_2024;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Locale;


public class Cook_Ingredient extends AppCompatActivity {

    Button homebtn;
    Button ingredientbtn;
    Button recipebtn;
    Button favoritesbtn;
    private IngredientAdapter ingredientAdapter;
    private List<Ingredient> ingredientlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cook_ingredient);

        homebtn = findViewById(R.id.home);
        ingredientbtn = findViewById(R.id.ingredient);
        recipebtn = findViewById(R.id.recipe);
        favoritesbtn = findViewById(R.id.favorites);

        ingredientlist = new ArrayList<>();
        RecyclerView ingredientRecy = findViewById(R.id.ingredientRecy);
        ingredientRecy.setLayoutManager(new LinearLayoutManager(this));

        ingredientAdapter = new IngredientAdapter(ingredientlist);
        ingredientRecy.setAdapter(ingredientAdapter);

        EditText searchIngredient = findViewById(R.id.search_ingredient);
        Button addIngredient = findViewById(R.id.add_ingredient);

        addIngredient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newItem = searchIngredient.getText().toString();
                if (!newItem.isEmpty()) {
                    ingredientAdapter.addItem(new Ingredient(newItem, getCurrentDate()));
                    searchIngredient.setText(""); // 입력 필드 비우기
                }
            }
        });


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

    private String getCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        return sdf.format(new Date());
    }


    public void openHomeActivity() {
        Intent intent = new Intent(Cook_Ingredient.this, MainActivity.class);
        startActivity(intent);
    }
    public void openIngredientActivity() {
        Intent intent = new Intent(Cook_Ingredient.this, Cook_Ingredient.class);
        startActivity(intent);
    }
    public void openRecipeActivity() {
        Intent intent = new Intent(Cook_Ingredient.this, Cook_Recipe.class);
        startActivity(intent);
    }
    public void openFavoritesActivity() {
        Intent intent = new Intent(Cook_Ingredient.this, Cook_Favorites.class);
        startActivity(intent);
    }
}

