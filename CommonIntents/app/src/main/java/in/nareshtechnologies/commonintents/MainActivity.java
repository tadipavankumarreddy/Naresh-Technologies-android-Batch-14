package in.nareshtechnologies.commonintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText url_et, maps_et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        url_et = findViewById(R.id.et_url);
        maps_et = findViewById(R.id.et_maps);
    }

    public void openBrowser(View view) {
        String link = url_et.getText().toString();
        Uri webpage = Uri.parse("https://"+link);
        Intent i = new Intent(Intent.ACTION_VIEW,webpage);
        startActivity(i);
    }

    public void openMaps(View view) {
        String address = maps_et.getText().toString();
        Uri mapsPage = Uri.parse("geo:0,0?q="+address);
        Intent i = new Intent(Intent.ACTION_VIEW,mapsPage);
        startActivity(i);
    }

    public void openWifi(View view) {
        Intent intent = new Intent(Settings.ACTION_BLUETOOTH_SETTINGS);
        startActivity(intent);
    }
}