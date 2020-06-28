package com.example.film_yab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class nextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        MovieModel movie = (MovieModel) getIntent().getSerializableExtra("movie");
        Toast.makeText(this, movie.getId() + " Next Activity", Toast.LENGTH_SHORT).show();

        TextView txtName = (TextView) findViewById(R.id.textviewname);
        TextView txtDate = (TextView) findViewById(R.id.textviewtarikh);
        TextView txtOverview = (TextView) findViewById(R.id.textViewreview);

        txtName.setText(movie.getTitle());
        txtOverview.setText(movie.getOverview());
    }
}
