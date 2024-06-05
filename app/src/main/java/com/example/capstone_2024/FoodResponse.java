package com.example.capstone_2024;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class FoodResponse {
    @SerializedName("COOKRCP01")
    private CookRcp cookRcp;

    public CookRcp getCookRcp() {
        return cookRcp;
    }

    public void setCookRcp(CookRcp cookRcp) {
        this.cookRcp = cookRcp;
    }

    public static class CookRcp {
        @SerializedName("total_count")
        private int totalCount;

        @SerializedName("row")
        private List<Food> foods;

        public int getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(int totalCount) {
            this.totalCount = totalCount;
        }

        public List<Food> getFoods() {
            return foods;
        }

        public void setFoods(List<Food> foods) {
            this.foods = foods;
        }
    }
}