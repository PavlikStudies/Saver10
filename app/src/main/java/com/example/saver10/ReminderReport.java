package com.example.saver10;

import android.app.PendingIntent;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class ReminderReport extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {


        //Intent intent2 = new Intent(this, ReminderReport.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

        String channel_ID = "0";

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, channel_ID)
                .setSmallIcon(R.drawable.ic_stat_notification)
                .setContentTitle("Saver 1.0").setContentText("Time to enter Your daily spendings!")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);

        notificationManager.notify(100, builder.build());



    }
}
