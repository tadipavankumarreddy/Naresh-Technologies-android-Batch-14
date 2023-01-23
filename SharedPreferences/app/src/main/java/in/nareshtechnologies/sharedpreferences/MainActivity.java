package in.nareshtechnologies.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name,age;
    TextView result;

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.person_name);
        age = findViewById(R.id.person_age);
        result = findViewById(R.id.result);

        preferences = getSharedPreferences("my_data_prefs",MODE_PRIVATE);

    }

    public void saveData(View view) {
        String n = name.getText().toString();
        int a = Integer.parseInt(age.getText().toString());
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("NAME",n);
        editor.putInt("AGE",a);
        /*All values will be cleared if this is called -> editor.clear();*/
        editor.apply();
        Toast.makeText(this, "Data Saved Successfully!", Toast.LENGTH_SHORT).show();
    }

    public void loadData(View view) {
        String n = preferences.getString("NAME","Def");
        int a = preferences.getInt("AGE",0);
        result.setText(n);
        result.append("\n"+a);
    }
}