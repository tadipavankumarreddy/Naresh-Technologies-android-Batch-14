package in.nareshtechnologies.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    ProgressBar progressBar;
    String url = "https://lucifer-quotes.vercel.app/api/";
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
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        fd = retrofit.create(FetchData.class);

        progressBar.setVisibility(View.INVISIBLE);
    }

    public void fetchData(View view) {
        progressBar.setVisibility(View.VISIBLE);
        fd.getData().enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String r = response.body();
                try {
                    JSONArray a = new JSONArray(r);
                    JSONObject jo = a.getJSONObject(0);
                    String q = jo.getString("quote");
                    tv.setText(q);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                progressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                tv.setText(t.getMessage());
                progressBar.setVisibility(View.INVISIBLE);
            }
        });

    }
}