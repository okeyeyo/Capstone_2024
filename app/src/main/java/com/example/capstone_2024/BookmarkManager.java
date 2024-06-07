package com.example.capstone_2024;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BookmarkManager {
    private static final String PREFS_NAME = "bookmarks";
    private static final String BOOKMARKS_KEY = "bookmarked_foods";

    private SharedPreferences sharedPreferences;

    public BookmarkManager(Context context) {
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    public void saveBookmarkStatus(List<String> bookmarkedFoods) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Set<String> set = new HashSet<>(bookmarkedFoods);
        editor.putStringSet(BOOKMARKS_KEY, set);
        editor.apply();
    }

    public List<String> loadBookmarkStatus() {
        Set<String> set = sharedPreferences.getStringSet(BOOKMARKS_KEY, new HashSet<>());
        return new ArrayList<>(set);
    }

    public void addBookmark(String foodId) {
        List<String> bookmarkedFoods = loadBookmarkStatus();
        bookmarkedFoods.add(foodId);
        saveBookmarkStatus(bookmarkedFoods);
    }

    public void removeBookmark(String foodId) {
        List<String> bookmarkedFoods = loadBookmarkStatus();
        bookmarkedFoods.remove(foodId);
        saveBookmarkStatus(bookmarkedFoods);
    }

    public boolean isBookmarked(String foodId) {
        return loadBookmarkStatus().contains(foodId);
    }
}
