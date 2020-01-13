package com.example.mapsapp1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }

    public void seeStadiumOnClick(View view) {
        Intent intent = new Intent(this, StadiumActivity.class);
        intent.putExtra("propName", "propValue");
        startActivity(intent);
    }

    public void getSeatsOnClick(View view) {
        Intent intent = new Intent(this, CategoryListActivity.class);
        startActivity(intent);
    }
}

