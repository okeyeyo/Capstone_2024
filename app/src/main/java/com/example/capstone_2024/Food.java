package com.example.capstone_2024;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class Food implements Parcelable { //음식 생성자

    private int id;
    private String name;
    private String ingredients;
    private String manual1;
    private String manual2;
    // Add more manual attributes up to manual20 as needed

    public Food() { // 기본 생성지
        this.id = 0; // 기본값 설정
        this.name = "";
        this.ingredients = "";
        this.manual1 = "";
        this.manual2 = "";
    }
    public Food(int id, String name, String ingredients, String manual1, String manual2) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
        this.manual1 = manual1;
        this.manual2 = manual2;
        // Initialize other manual attributes as needed
    }

    protected Food(Parcel in) {
        id = in.readInt();
        name = in.readString();
        ingredients = in.readString();
        manual1 = in.readString();
        manual2 = in.readString();
        // Read other manual attributes from parcel as needed
    }

    public static final Creator<Food> CREATOR = new Creator<Food>() {
        @Override
        public Food createFromParcel(Parcel in) {
            return new Food(in);
        }

        @Override
        public Food[] newArray(int size) {
            return new Food[size];
        }
    };

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }
    public void setIngredients(String ingredients){
        this.ingredients = ingredients;
    }

    public String getManual1() {
        return manual1;
    }
    public void setManual1(String manual1){
        this.manual1 = manual1;
    }
    public String getManual2() {
        return manual2;
    }
    public void setManual2(String manual2){
        this.manual2 = manual2;
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(ingredients);
        dest.writeString(manual1);
        dest.writeString(manual2);
        // Write other manual attributes to parcel as needed
    }
}

