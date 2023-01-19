package in.nareshtechnologies.dailysamachar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private String category = "all";
    private String url = "https://inshorts.deta.dev/news?category=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                /*Toast.makeText(MainActivity.this, parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();*/
                category = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void getNews(View view) {
        Intent i = new Intent(this,DisplayNews.class);
        i.putExtra("URL",url+category);
        startActivity(i);
    }
}

/**
 * Libraries that are going to be used for this project
 * - Volley ( A networking library developed by Google)
 * - Gson (to parse json data to Java pojo)
 * - Glide (an Image Loading Library)
 * - Material design lib (that comes by default) to develop attractive UI
 * */