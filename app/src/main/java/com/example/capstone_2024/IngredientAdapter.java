package com.example.capstone_2024;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class IngredientAdapter extends RecyclerView.Adapter<IngredientAdapter.ViewHolder> {

    private List<Ingredient> ingredientList;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView ingredientName;
        public TextView ingredientDay;
        public Button deleteButton;

        public ViewHolder(View itemView) {
            super(itemView);
            ingredientName = itemView.findViewById(R.id.ingredient_name);
            ingredientDay = itemView.findViewById(R.id.ingredient_day);
            deleteButton = itemView.findViewById(R.id.delate_ingredient);
        }
    }

    public IngredientAdapter(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ingredient_row_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Ingredient item = ingredientList.get(position);
        holder.ingredientName.setText(item.getName());
        holder.ingredientDay.setText(item.getTimestamp());
        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeItem(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return ingredientList.size();
    }

    public void addItem(Ingredient item) {
        ingredientList.add(item);
        notifyItemInserted(ingredientList.size() - 1);
    }

    public void removeItem(int position) {
        ingredientList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, ingredientList.size());
    }
}
