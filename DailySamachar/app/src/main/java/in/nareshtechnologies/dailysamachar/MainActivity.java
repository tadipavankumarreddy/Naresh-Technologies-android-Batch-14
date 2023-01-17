package in.nareshtechnologies.dailysamachar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

/**
 * Libraries that are going to be used for this project
 * - Volley ( A networking library developed by Google)
 * - Gson (to parse json data to Java pojo)
 * - Glide (an Image Loading Library)
 * - Material design lib (that comes by default) to develop attractive UI
 * */