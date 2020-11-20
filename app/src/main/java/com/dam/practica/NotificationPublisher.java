package com.dam.practica;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import static android.content.Context.NOTIFICATION_SERVICE;

public class NotificationPublisher extends BroadcastReceiver {

    private static NotificationPublisher instance = null;
    private static final String CHANNEL_ID = "notification_channel";
    private static final int NOTIFICATION_ID = 125;

    private NotificationManager mNotifyManager;

    public  NotificationPublisher() {
    }

    public static NotificationPublisher getInstance() {
        if(instance == null){
            instance = new NotificationPublisher();
        }
        return instance;
    }

    public void createNotificationChannel(Context context){
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            // Create a NotificationChannel
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID,"Notification", NotificationManager.IMPORTANCE_DEFAULT);
            //notificationChannel.enableLights(true);
            //notificationChannel.setLightColor(Color.RED);
            notificationChannel.enableVibration(true);
            notificationChannel.setDescription("Notification activity 2");

            mNotifyManager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
            mNotifyManager.createNotificationChannel(notificationChannel);
        }
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        createNotificationChannel(context);
        showNotification(context);
    }

    private void showNotification(Context context) {

        Bitmap icon = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_baseline_adb_24);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_baseline_adb_24)
                //.setLargeIcon(icon)
                .setContentTitle("Notificacion enviada")
                .setContentText("Aprendiste a enviar notificaciones")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
                //.setAutoCancel(true);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        notificationManager.notify(NOTIFICATION_ID, builder.build());

    }
}
