package com.example.nanovacationke;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;
public class HomeActivity extends AppCompatActivity{


    RecyclerView recyclerView;
    DatabaseReference mReference;
    FirebaseRecyclerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mReference = FirebaseDatabase.getInstance().getReference("CategoryPlace");
        recyclerView = findViewById(R.id.rv_places);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new FirebaseRecyclerAdapter<CategoryPlace, CategoryViewHolder>(CategoryPlace.class,R.layout.slideitemview,CategoryViewHolder.class,mReference) {
            @Override
            protected void populateViewHolder(CategoryViewHolder categoryViewHolder, CategoryPlace model, final int i) {
                categoryViewHolder.txtPlaceName.setText(model.getPlacename());
                Picasso.get().load(model.getImage()).into(categoryViewHolder.img_place);
                categoryViewHolder.img_place.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v ) {
                        Intent intent=new Intent(getApplicationContext(),PlaceDetailActivity.class);
                        intent.putExtra("CategoryPlaceId",adapter.getRef(i).getKey());
                        startActivity(intent);


                    }
                });
            }

        };

        recyclerView.setAdapter(adapter);



    }
}
