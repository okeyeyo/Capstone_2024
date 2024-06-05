package com.example.capstone_2024;
import java.io.Serializable;


public class Ingredient implements Serializable {
    private String name;
    private String timestamp;

    public Ingredient(String name, String timestamp) {
        this.name = name;
        this.timestamp = timestamp;
    }

    public String getName() {
        return name;
    }

    public String getTimestamp() {
        return timestamp;
    }
}
