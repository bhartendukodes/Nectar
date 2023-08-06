package com.bhartenduKodes.nectar.utils.extensions

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import com.bhartenduKodes.nectar.R
import com.bhartenduKodes.nectar.ui.activity.AuthenticationActivity

private const val NOTIFICATION_CHANNEL = "Offers"
private const val NOTIFICATION_CHANNEL_ID = "51"

object NotificationUtils{
    @RequiresApi(Build.VERSION_CODES.S)
    fun  sendSimpleNotification(
        title: String,
        message: String,
        applicationContext: Context
    ) {
        val notificationService = applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val intent = Intent(applicationContext, AuthenticationActivity::class.java)

        val pendingIntent = PendingIntent.getActivity(applicationContext,55,intent, PendingIntent.FLAG_MUTABLE)

        val notificationBuilder =
            NotificationCompat.Builder(applicationContext, NOTIFICATION_CHANNEL)
                .setContentTitle(title)
                .setContentText(message)
                .setChannelId(NOTIFICATION_CHANNEL_ID)
                .setSmallIcon(androidx.core.R.drawable.notification_bg)
                .addAction(R.drawable.ic_launcher_foreground,"Start",pendingIntent)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationService.createNotificationChannel(
                NotificationChannel(
                    NOTIFICATION_CHANNEL_ID,
                    NOTIFICATION_CHANNEL,
                    NotificationManager.IMPORTANCE_HIGH
                )
            )
        }

        notificationService.notify(55, notificationBuilder.build())
    }
}

@RequiresApi(Build.VERSION_CODES.S)
fun NotificationManager.sendSimpleNotification(
    title: String,
    message: String,
    applicationContext: Context
) {

    val intent = Intent(applicationContext,AuthenticationActivity::class.java)

    val pendingIntent = PendingIntent.getActivity(applicationContext,55,intent,PendingIntent.FLAG_MUTABLE)

    val notificationBuilder =
        NotificationCompat.Builder(applicationContext, NOTIFICATION_CHANNEL)
            .setContentTitle(title)
            .setContentText(message)
            .setChannelId(NOTIFICATION_CHANNEL_ID)
            .setSmallIcon(androidx.core.R.drawable.notification_bg)
            .addAction(R.drawable.ic_launcher_foreground,"Start",pendingIntent)

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        createNotificationChannel(
            NotificationChannel(
                NOTIFICATION_CHANNEL_ID,
                NOTIFICATION_CHANNEL,
                NotificationManager.IMPORTANCE_HIGH
            )
        )
    }

    notify(55, notificationBuilder.build())
}

@RequiresApi(Build.VERSION_CODES.S)
fun NotificationManager.sendOrderNotification(
    title: String,
    message: String,
    orderId:String,
    applicationContext: Context
) {

    val intent = Intent(applicationContext,AuthenticationActivity::class.java)
    intent.putExtra("orderId",orderId)

    val pendingIntent = PendingIntent.getActivity(applicationContext,55,intent,PendingIntent.FLAG_MUTABLE)

    val notificationBuilder =
        NotificationCompat.Builder(applicationContext, NOTIFICATION_CHANNEL)
            .setContentTitle(title)
            .setContentText(message)
            .setChannelId(NOTIFICATION_CHANNEL_ID)
            .setSmallIcon(androidx.core.R.drawable.notification_bg)
            .addAction(R.drawable.ic_launcher_foreground,"Start",pendingIntent)

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        createNotificationChannel(
            NotificationChannel(
                NOTIFICATION_CHANNEL_ID,
                NOTIFICATION_CHANNEL,
                NotificationManager.IMPORTANCE_HIGH
            )
        )
    }

    notify(55, notificationBuilder.build())

}