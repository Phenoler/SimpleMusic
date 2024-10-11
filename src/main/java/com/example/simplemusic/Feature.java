package com.example.simplemusic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Feature extends AppCompatActivity {

    private Button myfavorites;
    private Button locslmusics;
    private Button recommendeds;
    private Button settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feature);

        locslmusics = findViewById(R.id.localmusics);
        locslmusics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Feature.this, MainActivity.class);
                startActivity(intent);
            }
        });
        myfavorites = findViewById(R.id.myfavorites);
        myfavorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Feature.this, MainActivity.class);
                startActivity(intent);
            }
        });
        recommendeds = findViewById(R.id.recommendeds);
        recommendeds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Feature.this, Recommend.class);
                startActivity(intent);
            }
        });

    }
}