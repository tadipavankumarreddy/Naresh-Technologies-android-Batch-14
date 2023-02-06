package in.nareshtechnologies.standupremainder;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.core.app.NotificationCompat;

public class StandUpReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // when the onreceive method is invoked by a broadcast sent out by the alarm manager, we need to
        // show a notification to the user, asking him to just stand up for a minute.
        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("notify","Standup Reminder",NotificationManager.IMPORTANCE_HIGH);
            manager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context,"notify");
        builder.setSmallIcon(R.drawable.ic_baseline_man_2_24);
        builder.setContentTitle("Hey, It's time to stand up!");
        builder.setContentText("You are already sitting down there for more than 2 min. Now, Stand Up!!");
        builder.setAutoCancel(true);
        builder.setPriority(NotificationCompat.PRIORITY_HIGH);

        manager.notify(42,builder.build());
    }
}