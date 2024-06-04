package com.example.capstone_2024;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {
    private List<Food> foodList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Food food);
    }

    public FoodAdapter(List<Food> foodList ,OnItemClickListener listener) {
        this.foodList = foodList;
        this.listener = listener;
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
        //holder.ingredientsTextView.setText(food.getIngredients());
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public static class FoodViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTextView;
        //private TextView ingredientsTextView;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
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
