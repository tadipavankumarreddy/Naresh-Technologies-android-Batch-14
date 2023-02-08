package in.nareshtechnologies.contentreader;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String Authorities = "in.nareshtechnologies.android.CONTENT";
    public static final String COL2 = "person_name";
    public static final String COL3 = "person_age";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Uri uri = Uri.parse("content://"+Authorities);
        // Adding data
        ContentValues values = new ContentValues();
        values.put(COL2,"Naresh");
        values.put(COL3, 23);

        getContentResolver().insert(uri,values);

        Cursor c = getContentResolver().query(uri,null,null,null,null);

        TextView result = findViewById(R.id.result);

        result.setText("");
        // Whenever you get the data out of the databases, you would get it in Cursor
        c.moveToFirst();
        do{
            int id = c.getInt(0);
            String name = c.getString(1);
            int age = c.getInt(2);

            result.append("\n"+id+"  "+name+"  "+age+"\n");
        }while(c.moveToNext());



    }
}