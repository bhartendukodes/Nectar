package com.bhartenduKodes.nectar.fcm

import android.content.ContentValues.TAG
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.bhartenduKodes.nectar.utils.extensions.NotificationUtils
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class FcmService : FirebaseMessagingService() {


    @RequiresApi(Build.VERSION_CODES.S)
    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        Log.e(TAG, "Notification : $message")
        val orderId = message.data["orderId"]

        Log.e(TAG,"My OrderId $orderId")
        val notificationMessage = message.notification
        val title = notificationMessage?.title
        val body = notificationMessage?.body

        NotificationUtils.sendSimpleNotification(
            title.toString(),
            body.toString(),
            applicationContext
        )

//        val notificationService = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
//        notificationService.sendNotification(title.toString(), message.toString(), applicationContext)
    }

}