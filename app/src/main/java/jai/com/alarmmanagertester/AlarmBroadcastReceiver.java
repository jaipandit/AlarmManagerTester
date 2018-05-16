package jai.com.alarmmanagertester;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * The receiver that would receive the alarm broadcast.
 */
public class AlarmBroadcastReceiver extends BroadcastReceiver {

    public static final String ACTION_STRING = "com.jai.alarmmanagertester.broadcastreceiver.actionstring";

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Alarm received", Toast.LENGTH_LONG).show();
    }
}
