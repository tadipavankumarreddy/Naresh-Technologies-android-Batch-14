package in.nareshtechnologies.scoretracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // connect the Textview Object to the actual view on activity_main.xml
        score = findViewById(R.id.result);

        Log.i("MAIN","onCreate");

        if(savedInstanceState!=null && savedInstanceState.containsKey("DATA")){
            count = savedInstanceState.getInt("DATA");
            score.setText(String.valueOf(count));
        }

    }

    // Persist data across orientation changes of an Activity (Configuration changes)
    // SavedInstanceState
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("DATA",count);
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


    // TO Override the default functionality of the back button (<)
    @Override
    public void onBackPressed() {
        /* This line calls the super class onBackPressed(..) method
        super.onBackPressed();*/
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // alert dialogs can have title
        builder.setTitle("Do you really want to exit the app ?");
        // alert dialogs can display message (Content)
        builder.setMessage("click yes or no or cancel");
        // Alert diaogs can also show an icon along with them
        builder.setIcon(R.drawable.ic_baseline_baby_changing_station_24);

        // Alert dialogs can have three buttons
            // Positive
            // Negative
            // nertral
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
                // finish() method closes the current acitivity
            }
        });
        builder.setNegativeButton("NO", null);
        builder.setNeutralButton("CANCEL", null);

        // show() method should be called to show alert dialog box
        builder.show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.first:
                count = 0;
                score.setText(String.valueOf(count));
                break;

            case R.id.second:
                Toast.makeText(this, "Second option is selected", Toast.LENGTH_SHORT).show();
                break;

        }
        return true;
    }

    // TODO for options menu
    // Step 1: Create a xml file to create the options menu items
    // Step 2: Override onCreateOptionsMenu(...) for attaching the menu items to the activity
    // Step 3: get the menu options into action by overriding onOptionsItemSelected(...)

}