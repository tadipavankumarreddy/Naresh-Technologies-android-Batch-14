package in.nareshtechnologies.custombrodcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MyReceiver extends BroadcastReceiver {

    TextView tv;

    public MyReceiver(TextView tv) {
        this.tv = tv;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        if(intent.getAction() == MainActivity.ACTION_CUSTOM){
            tv.setText("CUSTOM BROADCAST RECEIVED");
        }
    }
}