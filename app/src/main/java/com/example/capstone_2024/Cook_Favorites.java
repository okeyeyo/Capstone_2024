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
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Cook_Favorites extends AppCompatActivity {

    ImageButton homebtn;
    Button ingredientbtn;
    Button recipebtn;
    Button favoritesbtn;

    FoodAdapter foodAdapter;
    private final List<Food> foodList = new ArrayList<>();
    private static final String apiKey = "https://openapi.foodsafetykorea.go.kr/api/221de0c2525840539c5c/COOKRCP01/json/";
    private static final String TAG = "Cook";
    private BookmarkManager bookmarkManager;
    private List<Boolean> bookmarkStatusList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cook_favorites);

        homebtn = findViewById(R.id.home);
        ingredientbtn = findViewById(R.id.ingredient);
        recipebtn = findViewById(R.id.recipe);
        favoritesbtn = findViewById(R.id.favorites);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        foodAdapter = new FoodAdapter(foodList,bookmarkStatusList,this,new FoodAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Food food) {
                // 클릭된 음식의 정보를 사용하여 원하는 작업을 수행
                // 예: 새로운 화면으로 이동하여 음식의 상세 정보 표시
                Intent intent = new Intent(Cook_Favorites.this, FoodDetailActivity.class);
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

        bookmarkManager = new BookmarkManager(this);

        loadBookmarkedFoods();
        foodAdapter.notifyDataSetChanged();

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
    private void loadBookmarkedFoods() {
        List<String> bookmarkedFoodIds = bookmarkManager.loadBookmarkStatus();
        for (String foodId : bookmarkedFoodIds) {
            searchFoodById(foodId);
        }
    }

    private void searchFoodById(String foodId) {
        FoodApiService apiService = RetrofitClient.getClient().create(FoodApiService.class);
        Call<FoodResponse> call = apiService.searchFoodById(foodId, apiKey);
        call.enqueue(new Callback<FoodResponse>() {
            @Override
            public void onResponse(@NonNull Call<FoodResponse> call, @NonNull Response<FoodResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Food food = response.body().getCookRcp().getFoods().get(0);
                    boolean isBookmarked = bookmarkManager.isBookmarked(foodId);
                    food.setBookmarked(isBookmarked);
                    foodList.add(food);
                    foodAdapter.notifyItemInserted(foodList.size() - 1);
                } else {
                    Toast.makeText(Cook_Favorites.this, "Failed to get food details", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<FoodResponse> call, @NonNull Throwable t) {
                Toast.makeText(Cook_Favorites.this, "API call failed: " + t.getMessage(), Toast.LENGTH_LONG).show();
                Log.e("Cook", "API call failed", t);  // Log the error
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
