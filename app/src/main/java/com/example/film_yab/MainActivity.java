package com.example.film_yab;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static String base_url= "https://api.themoviedb.org";

    TextView toolbarTitle;
    ImageButton toolbarAboutUsButton;

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





    }

    private void initialization(){
        toolbarTitle = findViewById(R.id.toolbarTitle);
        toolbarAboutUsButton = findViewById(R.id.toolbarAboutUsImageButton);
    }

}
