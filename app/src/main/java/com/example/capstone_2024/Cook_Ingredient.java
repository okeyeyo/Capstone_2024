package com.example.capstone_2024;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Locale;


public class Cook_Ingredient extends AppCompatActivity {

    ImageButton homebtn;
    Button ingredientbtn;
    Button recipebtn;
    Button find_recipebtn;
    private IngredientAdapter ingredientAdapter;
    private List<Ingredient> ingredientlist;
    private SharedPreferences sharedPreferences;
    private static final String PREFS_NAME = "ingredients_prefs";
    private static final String INGREDIENT_LIST_KEY = "ingredient_list";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cook_ingredient);

        homebtn = findViewById(R.id.home);
        ingredientbtn = findViewById(R.id.ingredient);
        recipebtn = findViewById(R.id.recipe);
        find_recipebtn = findViewById(R.id.find_recipe);

        sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        ingredientlist = loadIngredientList();
        RecyclerView ingredientRecy = findViewById(R.id.ingredientRecy);
        ingredientRecy.setLayoutManager(new LinearLayoutManager(this));

        ingredientAdapter = new IngredientAdapter(ingredientlist,this);
        ingredientRecy.setAdapter(ingredientAdapter);

        EditText searchIngredient = findViewById(R.id.search_ingredient);
        Button addIngredient = findViewById(R.id.add_ingredient);

        addIngredient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newItem = searchIngredient.getText().toString();
                if (!newItem.isEmpty()) {
                    ingredientAdapter.addItem(new Ingredient(newItem, getCurrentDate()));
                    saveIngredientList();
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
        find_recipebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFindRecipeActivity(ingredientlist);
            }
        });
    }
    private void openFindRecipeActivity(List<Ingredient> ingredientlist) {
        Intent intent = new Intent(Cook_Ingredient.this, Find_recipe.class);
        intent.putExtra("ingredient_list", new ArrayList<>(ingredientlist));
        startActivity(intent);
    }

    private String getCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        return sdf.format(new Date());
    }

    void saveIngredientList() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(ingredientlist);
        editor.putString(INGREDIENT_LIST_KEY, json);
        editor.apply();
    }

    private List<Ingredient> loadIngredientList() {
        Gson gson = new Gson();
        String json = sharedPreferences.getString(INGREDIENT_LIST_KEY, null);
        Type type = new TypeToken<ArrayList<Ingredient>>() {}.getType();
        List<Ingredient> list = gson.fromJson(json, type);
        return list != null ? list : new ArrayList<>();
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
}

