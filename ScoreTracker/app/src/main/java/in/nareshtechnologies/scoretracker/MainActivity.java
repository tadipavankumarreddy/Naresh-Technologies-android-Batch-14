package in.nareshtechnologies.scoretracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView score;
    int count = 0 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // connect the Textview Object to the actual view on activity_main.xml
        score = findViewById(R.id.result);

    }

    public void incrementScore(View view) {
        // When the + button is clicked, we shall invoke this method
       count++;
       score.setText(String.valueOf(count));
    }

    public void decrementScore(View view) {
        // When the - button is clicked, we shall invoke this method
       count--;
        score.setText(String.valueOf(count));
    }
}