package com.example.nanovacationke;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

public class DetailViewHolder extends RecyclerView.ViewHolder {


    public ImageView img_place,imgplace2,imgplace3,imgplace4;
    public DetailViewHolder(@NonNull View itemView) {
        super(itemView);
        img_place = itemView.findViewById(R.id.img_photo_id1);
        imgplace2 = itemView.findViewById(R.id.img_photo_id2);
        imgplace3 = itemView.findViewById(R.id.img_photo_id3);
        imgplace4 = itemView.findViewById(R.id.img_photo_id4);



    }
}


/*package com.example.nanovacationke;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PhotoAdapter extends  RecyclerView.Adapter<PhotoAdapter.CastViewHolder>{

    Context mcontext;
    List<Photosconstructor> mdata;

    @NonNull
    @Override
    public CastViewHolder onCreateViewHolder(@NonNull ViewGroup viewgroup, int viewType) {
        View view= LayoutInflater.from(mcontext).inflate(R.layout.slideitemview,viewgroup,false);
        return new PhotoAdapter.CastViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CastViewHolder holder, int position) {
       // holder.img.setImageResource(mdata.get(position).getImglink());

    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public PhotoAdapter(Context mcontext, List<Photosconstructor> mdata) {
        this.mcontext = mcontext;
        this.mdata = mdata;
    }

    public class CastViewHolder extends RecyclerView.ViewHolder{

        ImageView img;

        public CastViewHolder(@NonNull View itemView) {
            super(itemView);
            img= itemView.findViewById(R.id.img_view1);
        }
    }




}
**/