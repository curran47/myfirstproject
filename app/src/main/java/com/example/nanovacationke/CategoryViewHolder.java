package com.example.nanovacationke;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryViewHolder extends RecyclerView.ViewHolder {

    public TextView txtPlaceName;
    public ImageView img_place,img_place2s,img_place3s;
    public CategoryViewHolder(@NonNull View itemView) {
        super(itemView);
        txtPlaceName = itemView.findViewById(R.id.tv_itemview_id);
        img_place = itemView.findViewById(R.id.img_view1s);
        img_place2s = itemView.findViewById(R.id.img_view2s);
        img_place3s = itemView.findViewById(R.id.img_view3s);

    }
}

