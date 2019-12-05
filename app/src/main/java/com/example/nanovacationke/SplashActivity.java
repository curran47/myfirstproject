package com.example.nanovacationke;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Thread splash =new Thread(){
            @Override
            public void run() {
                try {
                    sleep(2000);
                    //write intent to go to the main activity
                    Intent go=new Intent(getApplicationContext(), RegisterActivity.class);
                    startActivity(go);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        splash.start();
    }
    }

