package in.nareshtechnologies.dailysamachar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

public class DisplayNews extends AppCompatActivity {

    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    // TODO (primary) to get the data and display it as a toast message
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_news);
        progressBar = findViewById(R.id.progressBar);
        recyclerView = findViewById(R.id.recyclerview);

        // get the URL
        String url = getIntent().getStringExtra("URL");
        // Use Volley (a networking library developed by Google) to fetch data from the network.
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        StringRequest request = new StringRequest(Request.Method.GET, url, response -> {
            progressBar.setVisibility(View.INVISIBLE);
            Gson gson = new Gson();
            SourceData sd = gson.fromJson(response,SourceData.class);
            NewsAdapter newsAdapter = new NewsAdapter(this,sd.getData());
            recyclerView.setAdapter(newsAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

        }, error -> {
            Toast.makeText(this, error.getMessage(), Toast.LENGTH_SHORT).show();
        });

        // Add the request to the requestQueue
        requestQueue.add(request);
    }
}