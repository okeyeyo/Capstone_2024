package com.example.capstone_2024;

import android.os.Parcel;
import android.os.Parcelable;

public class Ingredient implements Parcelable { //재료 구분
    private String name; // 재료 이름
    private String amount; // 재료량

    public Ingredient(String name, String amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName(){
    return name;
    }
    public void setName(String name){
        this.name = name;
    }

    protected Ingredient(Parcel in) {
        name = in.readString();
        amount = in.readString();
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(amount);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Ingredient> CREATOR = new Creator<Ingredient>() {
        @Override
        public Ingredient createFromParcel(Parcel in) {
            return new Ingredient(in);
        }

        @Override
        public Ingredient[] newArray(int size) {
            return new Ingredient[size];
        }
    };
}
