package in.nareshtechnologies.birthdaywishes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class WishesActivity extends AppCompatActivity {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wishes);
        tv = findViewById(R.id.textview1);
        Intent i = getIntent();
        String data = i.getStringExtra("KEY");
        tv.setText("Happy Birthday\n"+data);
    }
}