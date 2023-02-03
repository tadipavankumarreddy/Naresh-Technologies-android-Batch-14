package in.nareshtechnologies.custombrodcastreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String ACTION_CUSTOM = "nareshtechisgood";

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.textview);

        IntentFilter fi = new IntentFilter(ACTION_CUSTOM);
        registerReceiver(new MyReceiver(tv),fi);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(new MyReceiver(tv));
    }
}