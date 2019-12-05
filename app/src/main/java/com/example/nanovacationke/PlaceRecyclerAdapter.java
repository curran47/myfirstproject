package com.example.nanovacationke;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

//public class PlaceRecyclerAdapter extends RecyclerView.Adapter<PlaceRecyclerAdapter.MyViewHolder> {
    //Context context;
//    List<RecyclerPlaceConstructor> mdata;
//    //List<RecyclerPlaceConstructor> mmdata;
//
//   /* public PlaceRecyclerAdapter(List<RecyclerPlaceConstructor> mmdata) {
//        this.mmdata = mmdata;
//    }**/
//
//    public PlaceRecyclerAdapter(Context context, List<RecyclerPlaceConstructor> mdata) {
//        this.context = context;
//        this.mdata = mdata;
//
//
//    }
//
//
//    @NonNull
//    @Override
//    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
//
//        View view= LayoutInflater.from(context).inflate(R.layout.slideitemview,viewGroup,false);
//        return new MyViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
//       // holder.TvTitle.setText(mmdata.get(position).getTitle());
//       // holder.pager.setImageResource(mmdata.get(position).getThumbnail());
//        holder.TvTitle.setText(mdata.get(position).getTitle());
//        holder.pager.setImageResource(mdata.get(position).getThumbnail());
//        holder.pager.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context,PlaceDetailActivity.class);
//
//                // passing data to the book activity
//                //intent.putExtra("Title",mmdata.get(position).getTitle());
//                //intent.putExtra("Thumbnail",mmdata.get(position).getThumbnail());
//                intent.putExtra("Title",mdata.get(position).getTitle());
//                intent.putExtra("Thumbnail",mdata.get(position).getThumbnail());
//                context.startActivity(intent);
//                //ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(HomeActivity.class,ViewCompat.getTransitionName(RecyclerView));
//                //startActivity(intent,options.toBundle());
//
//            }
//        });
//
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return mdata.size();
//    }
//
//    public class MyViewHolder extends RecyclerView.ViewHolder {
//
//        private TextView TvTitle;
//        private ImageView pager;
//        public MyViewHolder(@NonNull View itemView) {
//            super(itemView);
//            TvTitle= itemView.findViewById(R.id.tv_itemview_id);
//            pager=itemView.findViewById(R.id.img_view1);
//        }
//    }
//}
