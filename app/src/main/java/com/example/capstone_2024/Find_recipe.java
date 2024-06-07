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
    private List<Boolean> bookmarkStatusList = new ArrayList<>();

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

        foodAdapter = new FoodAdapter(foodList, bookmarkStatusList,this,new FoodAdapter.OnItemClickListener() {
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
                intent.putExtra("manual2", food.getManual2());
                intent.putExtra("manual_img2", food.getManual_img2());
                intent.putExtra("manual3", food.getManual3());
                intent.putExtra("manual_img3", food.getManual_img3());
                intent.putExtra("manual4", food.getManual4());
                intent.putExtra("manual_img4", food.getManual_img4());
                intent.putExtra("manual5", food.getManual5());
                intent.putExtra("manual_img5", food.getManual_img5());
                intent.putExtra("manual6", food.getManual6());
                intent.putExtra("manual_img6", food.getManual_img6());
                intent.putExtra("manual7", food.getManual7());
                intent.putExtra("manual_img7", food.getManual_img7());
                intent.putExtra("manual8", food.getManual8());
                intent.putExtra("manual_img8", food.getManual_img8());
                intent.putExtra("manual9", food.getManual9());
                intent.putExtra("manual_img9", food.getManual_img9());
                intent.putExtra("manual10", food.getManual10());
                intent.putExtra("manual_img10", food.getManual_img10());
                intent.putExtra("manual11", food.getManual11());
                intent.putExtra("manual_img11", food.getManual_img11());
                intent.putExtra("manual12", food.getManual12());
                intent.putExtra("manual_img12", food.getManual_img12());
                intent.putExtra("manual13", food.getManual13());
                intent.putExtra("manual_img13", food.getManual_img13());
                intent.putExtra("manual14", food.getManual14());
                intent.putExtra("manual_img14", food.getManual_img14());
                intent.putExtra("manual15", food.getManual15());
                intent.putExtra("manual_img15", food.getManual_img15());
                intent.putExtra("manual16", food.getManual16());
                intent.putExtra("manual_img16", food.getManual_img16());
                intent.putExtra("manual17", food.getManual17());
                intent.putExtra("manual_img17", food.getManual_img17());
                intent.putExtra("manual18", food.getManual18());
                intent.putExtra("manual_img18", food.getManual_img18());
                intent.putExtra("manual19", food.getManual19());
                intent.putExtra("manual_img19", food.getManual_img19());
                intent.putExtra("manual20", food.getManual20());
                intent.putExtra("manual_img20", food.getManual_img20());
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