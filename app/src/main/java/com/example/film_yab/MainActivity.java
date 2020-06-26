package com.example.film_yab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static String base_url= "https://api.themoviedb.org/3/movie/popular?api_key=e1d914acbeeacc6dc7bb2e638f930eeb&language=en-US&page=1";

    TextView toolbarTitle;
    ImageButton toolbarAboutUsButton;
    RecyclerView movieRecyclerView;
    List<MovieModel> movies = new ArrayList<MovieModel>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialization();

        //toolbar
        toolbarTitle.setText(R.string.app_name);
        toolbarAboutUsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {

            }
        });


        //connect to server
        getMovies();


    }

    private void initialization(){
        toolbarTitle = findViewById(R.id.toolbarTitle);
        toolbarAboutUsButton = findViewById(R.id.toolbarAboutUsImageButton);
        movieRecyclerView = findViewById(R.id.mainActivityMovieRecyclerView);
        movieRecyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        movieRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
        movieRecyclerView.setHasFixedSize(false);
        //movieRecyclerView.setAdapter(new MovieRecyclerViewAdapter(this,movies));
    }

    private void getMovies(){

        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, base_url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("results");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject movie = jsonArray.getJSONObject(i);
                                MovieModel n = new MovieModel();
                                //n.setTitle(movie.getString("title"));
                                n.setTitle("");
                                n.setImage(movie.getString("poster_path"));
                                movies.add(i,n);
                            }
                            movieRecyclerView.setAdapter(new MovieRecyclerViewAdapter(MainActivity.this,movies));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        request.setShouldCache(false);
        queue.getCache().clear();
        queue.getCache().remove(base_url);

        queue.add(request);
    }

}
