package com.example.mapsapp1;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.github.chrisbanes.photoview.PhotoView;

public class StadiumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stadium);

        PhotoView photoView = (PhotoView) findViewById(R.id.camp_nou_view);
        photoView.setImageResource(R.drawable.camp_nou);
    }
}
