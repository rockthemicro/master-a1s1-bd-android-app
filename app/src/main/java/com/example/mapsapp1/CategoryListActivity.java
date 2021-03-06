package com.example.mapsapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.Iterator;
import java.util.Set;

public class CategoryListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_list);

        LinearLayout layout = findViewById(R.id.linearLayout3);
        Set<String> set = FirstActivity.stadium.keySet();
        Iterator<String> it = set.iterator();

        int i = 0;
        while (it.hasNext()) {
            final String s = it.next();
            Button btn = new Button(this);

            btn.setText(s);
            btn.setId(i++);
            btn.setOnClickListener(new View.OnClickListener() {
                String category = s;

                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), SectorListActivity.class);
                    intent.putExtra("category", category);
                    startActivity(intent);
                }
            });

            layout.addView(btn);
        }
    }
}
