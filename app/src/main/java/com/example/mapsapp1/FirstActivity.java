package com.example.mapsapp1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;

public class FirstActivity extends AppCompatActivity {
    String firebaseId = null;

    {
        FirebaseApp.initializeApp(this);
        FirebaseInstanceId firebaseInstanceId = FirebaseInstanceId.getInstance();
        firebaseId = firebaseInstanceId.getId();
    }

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

        System.out.println(firebaseId);System.out.println(firebaseId);System.out.println(firebaseId);System.out.println(firebaseId);
        Intent intent = new Intent(this, CategoryListActivity.class);
        startActivity(intent);
    }
}

