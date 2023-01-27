package in.nareshtechnologies.internalstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    EditText name,age;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.person_name);
        age = findViewById(R.id.person_age);
        result = findViewById(R.id.result);
    }

    public void saveData(View view) {
        String n = name.getText().toString();
        int a = Integer.parseInt(age.getText().toString());
        // You want to write to the file -> File should be writable. 
        // File OutPut Stream
        FileOutputStream fos;
        try {
            fos = openFileOutput("my_file.txt",MODE_PRIVATE);
            fos.write((n+"\n"+a).getBytes());
            fos.close(); // This is important to save the modifications done to the file
        } catch (Exception e) {
            e.printStackTrace();
        }

        Toast.makeText(this, "Data is write to the file successfully", Toast.LENGTH_SHORT).show();

    }

    public void loadData(View view) {

        FileInputStream fis;

        try {
            fis = openFileInput("my_file.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String line = "";
            StringBuilder sb = new StringBuilder();
            while((line = br.readLine())!=null){
                sb.append(line+"\n");
            }
            result.setText(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}