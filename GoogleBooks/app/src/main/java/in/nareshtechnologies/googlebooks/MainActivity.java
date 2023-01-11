package in.nareshtechnologies.googlebooks;

import androidx.appcompat.app.AppCompatActivity;

import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText bookName;
    private TextView result;
    private ProgressBar progressBar;
    private static final String LINK = "https://www.googleapis.com/books/v1/volumes?q=";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bookName = findViewById(R.id.editTextTextPersonName);
        result = findViewById(R.id.textView);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.INVISIBLE);

    }

    public void fetchData(View view) {
        if(isNetworkConnected()){
            progressBar.setVisibility(View.VISIBLE);
            // Todo: Get the data from internet and display it
            // Step 1: get the data from the edittext
            String query = bookName.getText().toString();
            // step 2: create AsyncTask and fetch data
            FetchData fetchData = new FetchData(progressBar,result);
            /* This is the wrong way -> fetchData.doInBackground();*/
            fetchData.execute(LINK+""+query);
        }else{
            Toast.makeText(this, "NETWORK UNAVAILABLE", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }
}