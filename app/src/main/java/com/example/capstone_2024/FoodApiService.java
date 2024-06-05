package com.example.capstone_2024;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface FoodApiService {

    @GET("")
    Call<Food> getFood(@Path("id") int foodId, @Query("apiKey") String apiKey);

    @GET("1/100/RCP_NM={name}") //이름으로 호출
    Call<FoodResponse> searchnameFood(@Path(value = "name" , encoded = true)
                                      String name, @Query("apikey") String apikey);
    @GET("1/100/RCP_PARTS_DTLS={ingredients}") // 재료로 호출
    Call<FoodResponse> searchingredientsFoods(@Path(value = "ingredients", encoded = true)
                                              String ingredients, @Query("apiKey") String apiKey);
    @GET("1/100")
    Call<FoodResponse> getAllFoods(@Query("api_key") String apiKey);
}