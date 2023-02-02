package in.nareshtechnologies.notifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    NotificationManager manager;
    String channel_id = "mynotichannel";
    String channel_name = "My Notification";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Notification is a system service.
        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    public void sendNotification(View view) {
        // Create a notification channel for all the android versions equal or above 8.0 (API 26)
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            // This condition will be true for all the versions that are greater than or equal to Oreo
            NotificationChannel channel = new NotificationChannel(channel_id,channel_name,NotificationManager.IMPORTANCE_HIGH);
            manager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,channel_id);
        builder.setContentTitle("Hi First Notification");
        builder.setContentText("This is the text to display along with the notification!");
        builder.setSmallIcon(R.drawable.ic_baseline_beach_access_24);
        builder.setAutoCancel(true);
        /*set importance for lowerend devices */
        builder.setPriority(NotificationCompat.PRIORITY_HIGH);

        /*// When the notification is tapped, you want to move the user to some place like MainActivity.java
        // Pending Intent is the description of an action that needs to be performed.
        // Pending Intent can be created in three ways
        //PendingIntent.getActivity() -> if you action is related to activities
        // PendingIntent.getBroadcast() -> if your action is related to broadcasts
        // PendingIntent.getService() -> if your action is related to services*/

        PendingIntent pi = PendingIntent.getActivity(this,123,
                new Intent(this, MainActivity.class), PendingIntent.FLAG_IMMUTABLE);
        builder.setContentIntent(pi);

        Bitmap b = BitmapFactory.decodeResource(getResources(),R.drawable.ggg);
        builder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(b));

        builder.addAction(R.drawable.ic_baseline_beach_access_24,"Read More",pi);
        builder.addAction(R.drawable.ic_baseline_beach_access_24,"Read Original",pi);

        manager.notify(42,builder.build());
    }


    public void cancelNotification(View view) {
        manager.cancel(42);
    }

    /**
     * Three major components
     *  - NotificationsCompat - Actual notification
     *  - NotificaitonManager - That manages the notifications by sending and cancelling
     *  - NotificationChannel - to let the user decide weather to get notifications from a channel or not!
     * */
}