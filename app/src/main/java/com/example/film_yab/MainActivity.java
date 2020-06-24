package com.example.film_yab;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
public class MainActivity extends AppCompatActivity {
    public static String base_url= "https://api.themoviedb.org";
 ListView mylistview;
 String[] movies;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mylistview=findViewById(R.id.listview);
        movies=new String[] {"me before you","great gatsby","blue jay","aqua man","wonder woman","me before you","great gatsby","blue jay","aqua man","wonder woman","x man","after"};
   ArrayAdapter<String> myadapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,movies);
   mylistview.setAdapter(myadapter);
    }

}
