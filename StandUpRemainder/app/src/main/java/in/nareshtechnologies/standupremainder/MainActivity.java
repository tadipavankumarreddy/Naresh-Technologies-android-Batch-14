package in.nareshtechnologies.standupremainder;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    // TODO: remind the user to stand up every one hour.
    AlarmManager manger;
    PendingIntent pi; // this pending intent would trigger a broadcast that will be caught by our broadcast receiver

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manger = (AlarmManager) getSystemService(ALARM_SERVICE);
        pi = PendingIntent.getBroadcast(this,22,new Intent(this,StandUpReceiver.class), PendingIntent.FLAG_IMMUTABLE);
    }

    public void alarmOn(View view) {
        long firstTriggerTime = SystemClock.elapsedRealtime() + (1000*60);
        long intervalTime = 1000*60*2;
        manger.setInexactRepeating(AlarmManager.ELAPSED_REALTIME,firstTriggerTime, intervalTime,pi);
    }

    public void alarmOff(View view) {
        manger.cancel(pi);
    }
}