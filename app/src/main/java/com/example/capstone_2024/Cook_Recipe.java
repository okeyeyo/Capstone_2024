package com.example.capstone_2024;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Cook_Recipe extends AppCompatActivity {

    Button homebtn;
    private EditText search_recipeEditText;
    FoodAdapter foodAdapter;
    private final List<Food> foodList = new ArrayList<>();
    private static final String apiKey = "https://openapi.foodsafetykorea.go.kr/api/221de0c2525840539c5c/COOKRCP01/json/";
    private static final String TAG = "Cook";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cook_recipe);

        homebtn = findViewById(R.id.home);
        Button searchButton = findViewById(R.id.searchButton);
        search_recipeEditText = findViewById(R.id.search_recipeEditText);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        foodAdapter = new FoodAdapter(foodList, new FoodAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Food food) {
                // 클릭된 음식의 정보를 사용하여 원하는 작업을 수행
                // 예: 새로운 화면으로 이동하여 음식의 상세 정보 표시
                Intent intent = new Intent(Cook_Recipe.this, FoodDetailActivity.class);
                intent.putExtra("foodId", food.getId());
                intent.putExtra("foodName", food.getName());
                intent.putExtra("ingredients", food.getIngredients());
                intent.putExtra("manual1", food.getManual1());
                intent.putExtra("manual_img1", food.getManual_img1());
                startActivity(intent);
            }
        });

        recyclerView.setAdapter(foodAdapter);

        // 화면에 들어가자마자 모든 음식을 가져오도록 설정
        fetchAllFoods();
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //searchFoods();
                nameFoods();
            }
        });

        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomeActivity();
            }
        });
    }

    public void openHomeActivity() {
        Intent intent = new Intent(Cook_Recipe.this, MainActivity.class);
        startActivity(intent);
    }

    private void fetchAllFoods() { // 검색어가 없을 때 처음에 보여주는 음식 리스트들
        FoodApiService apiService = RetrofitClient.getClient().create(FoodApiService.class);
        Call<FoodResponse> call = apiService.getAllFoods(apiKey); // 모든 음식 가져오는 API 호출
        call.enqueue(new Callback<FoodResponse>() {
            @Override
            public void onResponse(@NonNull Call<FoodResponse> call, @NonNull Response<FoodResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Food> foods = response.body().getCookRcp().getFoods();
                    foodList.clear();
                    foodList.addAll(foods);
                    foodAdapter.notifyDataSetChanged();
                    Log.d(TAG, "fetchAllFoods: Success - Foods loaded");
                } else {
                    Toast.makeText(Cook_Recipe.this, "No foods found", Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "fetchAllFoods: Failed to get response");
                }
            }

            @Override
            public void onFailure(@NonNull Call<FoodResponse> call, @NonNull Throwable t) {
                Toast.makeText(Cook_Recipe.this, "API call failed: " + t.getMessage(), Toast.LENGTH_LONG).show();
                Log.e("Cook", "API call failed", t);  // Log the error
            }
        });
    }

    private void nameFoods() { //이름
        String name = search_recipeEditText.getText().toString().trim(); // 사용자가 입력한 음식 이름
        if (!name.isEmpty()) { // null 값이 아니면
            FoodApiService apiService = RetrofitClient.getClient().create(FoodApiService.class);
            // api 호출해서 음식 목록을 가져오기. FoodApiService에 사용자가 입력한 음식의 이름과 api 키를 전달
            Call<FoodResponse> call = apiService.searchnameFood(name, apiKey);
            call.enqueue(new Callback<FoodResponse>() {
                @Override
                public void onResponse(@NonNull Call<FoodResponse> call, @NonNull Response<FoodResponse> response) {
                    if (response.isSuccessful() && response.body() != null) {
                        List<Food> foods = response.body().getCookRcp().getFoods();
                        foodList.clear();
                        foodList.addAll(foods);
                        foodAdapter.notifyDataSetChanged();
                        Log.d(TAG, "search: Success - Foods loaded");
                    } else {
                        Toast.makeText(Cook_Recipe.this, "No foods found", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(@NonNull Call<FoodResponse> call, @NonNull Throwable t) {
                    Toast.makeText(Cook_Recipe.this, "API call failed: " + t.getMessage(), Toast.LENGTH_LONG).show();
                    Log.e("Cook", "API call failed", t);  // Log the error
                }
            });
        } else {
            // 검색어가 비어있을 때의 동작
            fetchAllFoods();
        }
    }

   /* private void searchFoods() { //재료
        String ingredients = ingredientsEditText.getText().toString().trim(); // 사용자가 입력한 재료 받기
        if (!ingredients.isEmpty()) { // 입력한 재료가 null값이 아니면
            FoodApiService apiService = RetrofitClient.getClient().create(FoodApiService.class);
            // api호출해서 음식목록을 가져오기 //FoodApiService에 사용자가 입력한 재료와 api키를 전달
            Call<Food> call = apiService.searchingredientsFoods(ingredients, apiKey);
            call.enqueue(new Callback<Food>() {
                @Override
                public void onResponse(@NonNull Call<Food> call, @NonNull Response<Food> response) {
                    if (response.isSuccessful()) {
                        Food newFood = response.body();
                        if (newFood != null) {
                            foodList.add(newFood);
                            foodAdapter.notifyItemInserted(foodList.size() - 1);
                            Log.d(TAG, "search: Success - Foods loaded");
                        } else {
                            Toast.makeText(Cook.this, "No foods found", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(Cook.this, "Failed to get response", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "searchFoods: Failed to get response");
                    }
                }
                @Override
                public void onFailure(@NonNull Call<Food> call, @NonNull Throwable t) {
                    Toast.makeText(Cook.this, "API call failed: " + t.getMessage(), Toast.LENGTH_LONG).show();
                    Log.e("Cook", "API call failed", t);  // Log the error
                }
            });
        } else {
            // 검색어가 비어있을 때의 동작
            fetchAllFoods();

        }

    }*/


}

