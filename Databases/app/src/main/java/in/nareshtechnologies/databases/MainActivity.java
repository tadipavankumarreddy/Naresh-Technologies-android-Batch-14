package in.nareshtechnologies.databases;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name,age;
    TextView result;
    DatabaseHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.person_name);
        age = findViewById(R.id.person_age);
        result = findViewById(R.id.result);
        
        helper = new DatabaseHelper(this);
    }

    public void saveData(View view) {
        String n = name.getText().toString();
        int a = Integer.parseInt(age.getText().toString());
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COL2, n);
        values.put(DatabaseHelper.COL3, a);
        helper.insertData(values);
        Toast.makeText(this, "DONE", Toast.LENGTH_SHORT).show();
    }

    public void loadData(View view) {
        result.setText("");
        // Whenever you get the data out of the databases, you would get it in Cursor
        Cursor c = helper.getAllData();
        c.moveToFirst();
        do{
            int id = c.getInt(0);
            String name = c.getString(1);
            int age = c.getInt(2);

            result.append("\n"+id+"  "+name+"  "+age+"\n");
        }while(c.moveToNext());
    }
}