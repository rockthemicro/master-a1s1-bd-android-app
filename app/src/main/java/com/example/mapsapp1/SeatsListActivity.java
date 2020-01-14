package com.example.mapsapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.List;

public class SeatsListActivity extends AppCompatActivity {
    private String category;
    private String sector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seats_list);

        Intent intent = getIntent();
        category = intent.getStringExtra("category");
        sector = intent.getStringExtra("sector");

        System.out.println(category + " " + sector);

        LinearLayout layout = findViewById(R.id.linearLayout5);
        List<Integer> seats = FirstActivity.stadium.get(category).get(sector);
        int i = 1000;
        int j = 0;
        for (int row = 1; row <= FirstActivity.rowsPerSector; row++) {
            for (int seat = 1; seat <= FirstActivity.seatsPerRow; seat++) {
                Button btn = new Button(this);

                btn.setText("Row " + row + ", Seat " + seat + " is " + (seats.get(j++).equals(0) ? "free" : "occupied"));
                btn.setId(i++);
                layout.addView(btn);
            }
        }
    }
}
