package com.example.nanovacationke;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;


import androidx.recyclerview.widget.GridLayoutManager;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class PlaceDetailActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    FirebaseDatabase mDatabase;
    DatabaseReference imagelist;
    String categoryId = "";
    FirebaseRecyclerAdapter<Photosconstructor, DetailViewHolder> adapter;
    private RecyclerView.LayoutManager layoutManager;
    WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_detail);



        mDatabase = FirebaseDatabase.getInstance();
        imagelist = mDatabase.getReference("PlaceDetail");

        webView=findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());


        recyclerView = findViewById(R.id.rv_photo_id);
        recyclerView.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);

        if (getIntent() != null)
            categoryId = getIntent().getStringExtra("CategoryPlaceId");
        if (!categoryId.isEmpty() && categoryId != null) {


            LoadListImages(categoryId);


        }
    }

    private void LoadListImages(String categoryId) {

        adapter = new FirebaseRecyclerAdapter<Photosconstructor, DetailViewHolder>(Photosconstructor.class,
                R.layout.item_photos,
                DetailViewHolder.class,
                imagelist.orderByChild("id").equalTo(categoryId)) { //Select from placedetail where Id = categoryID
            @Override
            protected void populateViewHolder(DetailViewHolder detailViewHolder, Photosconstructor photosconstructor, int i) {

                detailViewHolder.txtdetails.setText(photosconstructor.getText());
                Picasso.get().load(photosconstructor.getImage1()).into(detailViewHolder.img_place);
                Picasso.get().load(photosconstructor.getImage2()).into(detailViewHolder.imgplace2);
                Picasso.get().load(photosconstructor.getImage3()).into(detailViewHolder.imgplace3);
                Picasso.get().load(photosconstructor.getImage4()).into(detailViewHolder.imgplace4);
                webView.loadUrl(photosconstructor.getButton());


            }
        };
        recyclerView.setAdapter(adapter);

    }
}





















