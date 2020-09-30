package com.josrangel.recyclerviewejemplo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.josrangel.recyclerviewejemplo.entity.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    AdapterRecycler adapterRecycler;
    User[] users = new User[10];
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler);

        adapterRecycler = new AdapterRecycler(this, users);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        conexionJsonArrayPlaceholderObject();
    }

    public void conexionJsonArrayPlaceholderObject(){
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://jsonplaceholder.typicode.com/users";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.i("lala",response.toString());
                for (int i=0; i<response.length(); i++){

                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        Log.i("lala",jsonObject.toString());
                        //User user = new User(jsonObject);
                        users[i] = new User(jsonObject);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                recyclerView.setAdapter(adapterRecycler);
                //texto.setText("Content: " + response);
            }
        },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this,error.toString(),Toast.LENGTH_LONG).show();
            }
        });


        queue.add(jsonArrayRequest);
    }
}