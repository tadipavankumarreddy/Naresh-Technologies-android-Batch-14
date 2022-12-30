package in.nareshtechnologies.birthdaywishes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText n;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        n = findViewById(R.id.name);
    }

    public void wishMe(View view) {
        String name = n.getText().toString();
        Intent i = new Intent(this,WishesActivity.class);
        i.putExtra("KEY",name);
        startActivity(i);
    }
}