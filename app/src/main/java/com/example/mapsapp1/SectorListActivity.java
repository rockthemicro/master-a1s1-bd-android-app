package com.example.mapsapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.Iterator;
import java.util.Set;

public class SectorListActivity extends AppCompatActivity {

    private String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sector_list);

        Intent intent = getIntent();
        category = intent.getStringExtra("category");
        System.out.println(category);

        LinearLayout layout = findViewById(R.id.linearLayout4);
        Set<String> set = FirstActivity.stadium.get(category).keySet();
        Iterator<String> it = set.iterator();

        int i = 100;
        while (it.hasNext()) {
            final String s = it.next();
            Button btn = new Button(this);

            btn.setText(s);
            btn.setId(i++);
            btn.setOnClickListener(new View.OnClickListener() {
                String sector = s;

                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), SeatsListActivity.class);
                    intent.putExtra("category", category);
                    intent.putExtra("sector", sector);
                    startActivity(intent);
                }
            });

            layout.addView(btn);
        }
    }
}
