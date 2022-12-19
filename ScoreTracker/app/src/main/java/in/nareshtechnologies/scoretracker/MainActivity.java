package in.nareshtechnologies.scoretracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Whenever a method is called, Print a log statement
    // log statements are generally used for debugging an application
    // so that we will be able to find the imp happenings in the app

    TextView score;
    int count = 0 ;

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("MAIN","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("MAIN","onStop");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // connect the Textview Object to the actual view on activity_main.xml
        score = findViewById(R.id.result);

        Log.i("MAIN","onCreate");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("MAIN","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("MAIN","onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("MAIN","onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("MAIN","onDestroy");
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