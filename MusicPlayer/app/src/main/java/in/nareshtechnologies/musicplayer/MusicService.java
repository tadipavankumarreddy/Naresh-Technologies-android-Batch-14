package in.nareshtechnologies.musicplayer;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MusicService extends Service {

    MediaPlayer player;

    public MusicService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // To intialize the task and start the service
    @Override
    public void onCreate() {
        super.onCreate();
        player = MediaPlayer.create(this,R.raw.audio);
        player.setLooping(false);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        player.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        player.stop();
    }
}