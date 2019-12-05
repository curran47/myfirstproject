package com.example.nanovacationke;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryViewHolder extends RecyclerView.ViewHolder {

    public TextView txtPlaceName;
    public ImageView img_place;
    public CategoryViewHolder(@NonNull View itemView) {
        super(itemView);
        txtPlaceName = itemView.findViewById(R.id.tv_itemview_id);
        img_place = itemView.findViewById(R.id.img_view1);

    }
}

