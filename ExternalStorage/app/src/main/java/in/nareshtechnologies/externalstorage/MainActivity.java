package in.nareshtechnologies.externalstorage;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
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

    //We need to check if the external Storage is available or not
    boolean isAvailable = false, isWritable = false, isReadable = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.person_name);
        age = findViewById(R.id.person_age);
        result = findViewById(R.id.result);

        // to check if the external storage is available, is Readable and is Writable.,
        String state = Environment.getExternalStorageState();
        if(Environment.MEDIA_MOUNTED.equals(state)){
            isAvailable = isReadable = isWritable = true;
            result.setText("YES");
        }else if(Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)){
            isAvailable = isReadable = true;
        }

        if(checkSelfPermission(WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this, "PERMISSION GRANTED", Toast.LENGTH_SHORT).show();
        }else{
            requestPermissions(new String[]{WRITE_EXTERNAL_STORAGE, READ_EXTERNAL_STORAGE},123);
        }

    }

    public void saveData(View view) {
        if(checkSelfPermission(WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            String n = name.getText().toString();
            int a = Integer.parseInt(age.getText().toString());

            File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
            File file = new File(folder, "my_file_ext.txt");

            FileOutputStream fos;

            try {
                fos = new FileOutputStream(file);
                fos.write((n + "\n" + a).getBytes());
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public void loadData(View view) {

        File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File file = new File(folder,"my_file_ext.txt");

        FileInputStream fis;

        try {
            fis = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String line = "";
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine())!=null){
                sb.append(line+"\n");
            }
            result.setText(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}