package jai.com.alarmmanagertester;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set the alarm now.
        AlarmManager manager = (AlarmManager) getSystemService(ALARM_SERVICE);


        /**
         * 1. Test statically registered Broadcast Receiver
         *
         * a. Register the broadcast receiver statically in the manifest.
         * b. Set an implicit intent.
         * c.  1. Now if App targets less that Oreo: Even the device is running Oreo we should receive the implicit intent.
         *     2. If the app targets Oreo or higher we should not receive the broadcast.
         *
         *     That would means that the System behaviors depends on your targetSdkVersion. This tells the system that the app well understands this
         *     platform versions and ready to handle the system behavior on this level. In counter, if the app targets lesser version and even if
         *     the app is running on newer version the system would not enable those new behavior changes, Because the app indicated that I dont
         *     well confront, but confront a previous version and please behave how you behave on older versions.
         *
         *     Result: It behaved accordingly!! targetSdkVersion is super crucial.
         */
        manager.set(AlarmManager.ELAPSED_REALTIME, SystemClock.elapsedRealtime() + 10, getImplicitAlarmIntent());

        /**
         * 2. Test Alarm manager. Register dynamic receiver.
         */

    }

    /**
     * Gets the implicit broadcast intent.
     *
     * @return
     */
    private PendingIntent getExplicitAlarmIntent() {
        // Explicit broadcast intent.
        Intent intent = new Intent(getApplicationContext(), AlarmBroadcastReceiver.class);
        return PendingIntent.getBroadcast(this, 0, intent, 0);
    }

    /**
     * Gets the explicit broadcast intent.
     *
     * @return
     */
    private PendingIntent getImplicitAlarmIntent() {
        // Implicit broadcast intent.
        Intent intent = new Intent(AlarmBroadcastReceiver.ACTION_STRING);
        return PendingIntent.getBroadcast(this, 0, intent, 0);
    }

}
