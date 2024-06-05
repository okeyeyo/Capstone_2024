package com.example.capstone_2024;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Find_recipe extends AppCompatActivity  {

    ImageButton homebtn;
    Button ingredientbtn;
    Button recipebtn;
    Button favoritesbtn;
    FoodAdapter foodAdapter;
    private List<Ingredient> ingredientList;
    private final List<Food> foodList = new ArrayList<>();
    private static final String apiKey = "https://openapi.foodsafetykorea.go.kr/api/221de0c2525840539c5c/COOKRCP01/json/";
    private static final String TAG = "Find_recipe";

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_recipe);

        homebtn = findViewById(R.id.home);
        ingredientbtn = findViewById(R.id.ingredient);
        recipebtn = findViewById(R.id.recipe);
        favoritesbtn = findViewById(R.id.favorites);
        ingredientList = (List<Ingredient>) getIntent().getSerializableExtra("ingredient_list");

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        foodAdapter = new FoodAdapter(foodList, new FoodAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Food food) {
                // 클릭된 음식의 정보를 사용하여 원하는 작업을 수행
                // 예: 새로운 화면으로 이동하여 음식의 상세 정보 표시
                Intent intent = new Intent(Find_recipe.this, FoodDetailActivity.class);
                intent.putExtra("foodId", food.getId());
                intent.putExtra("foodName", food.getName());
                intent.putExtra("ingredients", food.getIngredients());
                intent.putExtra("manual1", food.getManual1());
                intent.putExtra("manual_img1", food.getManual_img1());
                startActivity(intent);
            }
        });

        recyclerView.setAdapter(foodAdapter);

        searchFoods(ingredientList);

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
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void openIngredientActivity() {
        Intent intent = new Intent(this, Cook_Ingredient.class);
        startActivity(intent);
    }
    public void openRecipeActivity() {
        Intent intent = new Intent(this, Cook_Recipe.class);
        startActivity(intent);
    }
    public void openFavoritesActivity() {
        Intent intent = new Intent(this, Cook_Favorites.class);
        startActivity(intent);
    }

    private void searchFoods(List<Ingredient> ingredientlist) {
        if (ingredientlist != null && !ingredientlist.isEmpty()) {
            // 재료 리스트에서 재료 이름을 추출하여 문자열로 결합
            StringBuilder ingredientsBuilder = new StringBuilder();
            for (Ingredient ingredient : ingredientlist) {
                if (ingredientsBuilder.length() > 0) {
                    ingredientsBuilder.append(",");
                }
                ingredientsBuilder.append(ingredient.getName());
            }
            String ingredients = ingredientsBuilder.toString();

            FoodApiService apiService = RetrofitClient.getClient().create(FoodApiService.class);
            // api호출해서 음식목록을 가져오기 //FoodApiService에 사용자가 입력한 재료와 api키를 전달
            Call<FoodResponse> call = apiService.searchingredientsFoods(ingredients, apiKey);
            call.enqueue(new Callback<FoodResponse>() {
                @Override
                public void onResponse(@NonNull Call<FoodResponse> call, @NonNull Response<FoodResponse> response) {
                    if (response.isSuccessful() && response.body() != null) {
                        List<Food> foods = response.body().getCookRcp().getFoods();
                        if (foods != null && !foods.isEmpty()) {
                            foodList.clear();
                            foodList.addAll(foods);
                            foodAdapter.notifyDataSetChanged();
                            Log.d(TAG, "searchFoods: Success - Foods loaded");
                        } else {
                            Toast.makeText(Find_recipe.this, "No foods found", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(Find_recipe.this, "Failed to get response", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "searchFoods: Failed to get response");
                    }
                }

                @Override
                public void onFailure(@NonNull Call<FoodResponse> call, @NonNull Throwable t) {
                    Toast.makeText(Find_recipe.this, "API call failed: " + t.getMessage(), Toast.LENGTH_LONG).show();
                    Log.e("Cook", "API call failed", t);  // Log the error
                }
            });
        }else {
            Log.d(TAG, "searchFoods: No ingredients provided");
            Toast.makeText(Find_recipe.this, "No ingredients provided", Toast.LENGTH_SHORT).show();
        }
    }

}