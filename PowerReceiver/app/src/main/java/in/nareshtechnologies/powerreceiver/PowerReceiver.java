package in.nareshtechnologies.powerreceiver;

import static android.content.Intent.ACTION_POWER_CONNECTED;
import static android.content.Intent.ACTION_POWER_DISCONNECTED;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;

public class PowerReceiver extends BroadcastReceiver {

    Context context;
    ImageView image;

    public static final String ACTION_CUSTOM = "nareshtechisgood";

    public PowerReceiver(Context context, ImageView image) {
        this.context = context;
        this.image = image;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        if(intent.getAction().equals(ACTION_POWER_CONNECTED)){
            image.setImageResource(R.drawable.ic_baseline_battery_charging_full_24);
        }else if(intent.getAction().equals(ACTION_POWER_DISCONNECTED)){
            image.setImageResource(R.drawable.ic_baseline_battery_1_bar_24);
        }else{
            image.setImageResource(R.drawable.ic_launcher_background);
        }
    }
}