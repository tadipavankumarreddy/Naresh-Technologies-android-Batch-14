package in.nareshtechnologies.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    ProgressBar progressBar;
    String url = "https://inshorts.deta.dev/";
    Retrofit retrofit;
    FetchData fd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.textView);
        progressBar = findViewById(R.id.progressBar);

        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        fd = retrofit.create(FetchData.class);

        progressBar.setVisibility(View.INVISIBLE);
    }

    public void fetchData(View view) {
        progressBar.setVisibility(View.VISIBLE);
        tv.setText("");
        fd.getData().enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Example e = response.body();
                List<Datum> d = e.getData();
                for(Datum datum: d){
                    tv.append(datum.getTitle()+"\n");
                }
                progressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Gone", Toast.LENGTH_SHORT).show();
            }
        });

    }
}