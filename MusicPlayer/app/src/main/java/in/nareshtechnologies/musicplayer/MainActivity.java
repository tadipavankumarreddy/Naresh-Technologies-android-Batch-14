package in.nareshtechnologies.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void playMusic(View view) {
        Intent i = new Intent(this,MusicService.class);
        startService(i);
    }

    public void stopMusic(View view) {
        Intent i = new Intent(this,MusicService.class);
        stopService(i);
    }
}