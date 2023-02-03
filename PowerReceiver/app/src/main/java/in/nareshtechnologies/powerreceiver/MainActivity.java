package in.nareshtechnologies.powerreceiver;

import static android.content.Intent.ACTION_POWER_CONNECTED;
import static android.content.Intent.ACTION_POWER_DISCONNECTED;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);

        IntentFilter filter = new IntentFilter();
        filter.addAction(ACTION_POWER_CONNECTED);
        filter.addAction(ACTION_POWER_DISCONNECTED);
        filter.addAction(PowerReceiver.ACTION_CUSTOM);

        // Register the broadcast
        registerReceiver(new PowerReceiver(this,imageView),filter);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // unregister
        unregisterReceiver(new PowerReceiver(this,imageView));
    }

    public void button(View view) {
        Intent intent = new Intent(PowerReceiver.ACTION_CUSTOM);
        sendBroadcast(intent);
    }
}

