package com.example.film_yab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

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
        ImageView image = (ImageView) findViewById(R.id.imageView1) ;
        txtName.setText(movie.getTitle());
        txtOverview.setText(movie.getOverview());
        txtDate.setText(movie.getRelease_date());

        Picasso.get().load("https://image.tmdb.org/t/p/w500"+movie.getImage()).fit().into(image);

    }
}
