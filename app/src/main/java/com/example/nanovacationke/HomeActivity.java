package com.example.nanovacationke;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.squareup.picasso.Picasso;
public class HomeActivity extends AppCompatActivity {


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


        adapter = new FirebaseRecyclerAdapter<CategoryPlace, CategoryViewHolder>(CategoryPlace.class, R.layout.slideitemview, CategoryViewHolder.class, mReference) {
            @Override
            protected void populateViewHolder(CategoryViewHolder categoryViewHolder, CategoryPlace model, final int i) {
                categoryViewHolder.txtPlaceName.setText(model.getPlacename());
                Picasso.get().load(model.getImage()).into(categoryViewHolder.img_place);
                Picasso.get().load(model.getImage3()).into(categoryViewHolder.img_place2s);
                Picasso.get().load(model.getImage2()).into(categoryViewHolder.img_place3s);
                categoryViewHolder.txtPlaceName.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), PlaceDetailActivity.class);
                        intent.putExtra("CategoryPlaceId", adapter.getRef(i).getKey());
                        startActivity(intent);


                    }
                });
            }

        };
        recyclerView.setAdapter(adapter);
    }

        private void firebasesearch (String searchtext){
            Query firebasesearchquery = mReference.orderByChild("placename").startAt(searchtext).endAt(searchtext + "\uf0ff");
            FirebaseRecyclerAdapter<CategoryPlace, CategoryViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<CategoryPlace, CategoryViewHolder>(CategoryPlace.class,
                    R.layout.slideitemview,
                    CategoryViewHolder.class,
                    firebasesearchquery) {
                @Override
                protected void populateViewHolder(CategoryViewHolder categoryViewHolder, CategoryPlace categoryPlace, int i) {
                    categoryViewHolder.txtPlaceName.setText(categoryPlace.getPlacename());
                    Picasso.get().load(categoryPlace.getImage()).into(categoryViewHolder.img_place);
                    Picasso.get().load(categoryPlace.getImage3()).into(categoryViewHolder.img_place2s);
                    Picasso.get().load(categoryPlace.getImage2()).into(categoryViewHolder.img_place3s);

                }
            };

            recyclerView.setAdapter(firebaseRecyclerAdapter);
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.itemmenu,menu);
        MenuItem item=menu.findItem(R.id.search);
        SearchView searchView=(SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                firebasesearch(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                firebasesearch(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}
