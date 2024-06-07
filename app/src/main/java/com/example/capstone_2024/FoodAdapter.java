package com.example.capstone_2024;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {
    private List<Food> foodList;
    private OnItemClickListener listener;
    private BookmarkManager bookmarkManager;
    private Context context;
    private static final String PREF_NAME = "BookmarkPreferences";

    public interface OnItemClickListener {
        void onItemClick(Food food);
    }

    public FoodAdapter(List<Food> foodList ,List<Boolean> bookmarkStatusList,Context context,OnItemClickListener listener) {
        this.foodList = foodList;
        this.listener = listener;
        this.bookmarkManager = new BookmarkManager(context);
        this.context = context;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_food, parent, false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        Food food = foodList.get(position);
        holder.bind(food, listener);
        holder.nameTextView.setText(food.getName());
        holder.bookmarkButton.setImageResource(food.isBookmarked() ? R.drawable.star : R.drawable.empty_star);

        holder.bookmarkButton.setOnClickListener(v -> {
            if (food.isBookmarked()) {
                bookmarkManager.removeBookmark(food.getId());
                food.setBookmarked(false); // 북마크 상태 변경
                holder.bookmarkButton.setImageResource(R.drawable.empty_star);
            } else {
                bookmarkManager.addBookmark(food.getId());
                food.setBookmarked(true); // 북마크 상태 변경
                holder.bookmarkButton.setImageResource(R.drawable.star);
            }
        });
    }





    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTextView;
        private ImageButton bookmarkButton;
        //private TextView ingredientsTextView;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            bookmarkButton = itemView.findViewById(R.id.bookmark_button);
            //ingredientsTextView = itemView.findViewById(R.id.ingredientsTextView);
        }

        public void bind(final Food food, final OnItemClickListener listener) {
            nameTextView.setText(food.getName());
            //ingredientsTextView.setText(food.getIngredients());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(food);
                }
            });
        }
    }

}
