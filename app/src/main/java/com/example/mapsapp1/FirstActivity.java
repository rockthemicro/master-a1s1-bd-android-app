package com.example.mapsapp1;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirstActivity extends AppCompatActivity {

    private String firebaseId = null;

    private List<String> respList = null;
    static public Map<String, Map<String, List<Integer>>> stadium = new HashMap<>();
    static public int rowsPerSector = 0;
    static public int seatsPerRow = 0;

    private Handler handler = new Handler();
    private Runnable runnableCode = new Runnable() {

        @Override
        public void run() {
            handler.postDelayed(this, 2000);
        }
    };

    {
        FirebaseApp.initializeApp(this);
        FirebaseInstanceId firebaseInstanceId = FirebaseInstanceId.getInstance();
        firebaseId = firebaseInstanceId.getId();


        /* setup kafka produce periodically */
        //handler.post(runnableCode);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        if (respList == null) {
            RequestQueue queue = Volley.newRequestQueue(this);
            String url = "http://" + getResources().getString(R.string.server_ipport) + "/api/app/getStadiumSectors";
            StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONArray respArray = new JSONArray(response);
                                respList = new ArrayList<>();

                                rowsPerSector = respArray.getInt(respArray.length() - 2);
                                seatsPerRow = respArray.getInt(respArray.length() - 1);

                                for (int i = 0; i < respArray.length() - 2; i++) {
                                    respList.add(respArray.get(i).toString());

                                    String tmp = respArray.get(i).toString();
                                    String[] parts = tmp.split("\\.");
                                    String category = parts[0];
                                    String sector = parts[1];

                                    if (stadium.containsKey(category) == false) {
                                        stadium.put(category, new HashMap<String, List<Integer>>());
                                    }

                                    Map<String, List<Integer>> map = stadium.get(category);
                                    List<Integer> seats = new ArrayList<>();
                                    for (int j = 1; j <= rowsPerSector; j++) {
                                        for (int k = 1; k <= seatsPerRow; k++) {
                                            seats.add(0);
                                        }
                                    }
                                    map.put(sector, seats);
                                }
                                System.out.println(stadium);


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            System.out.println(error.toString());
                        }
                    }
            );

            queue.add(stringRequest);
        }
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

