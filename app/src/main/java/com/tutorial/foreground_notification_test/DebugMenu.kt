package com.tutorial.foreground_notification_test

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat

object DebugMenu {

    private const val NOTIFICATION_ID = "debug"

    fun init(application: Application) {
        val intent = Intent(application, DebugBroadcastReceiver::class.java)

        val pendingIntent: PendingIntent =
            PendingIntent.getBroadcast(application, 0, intent, 0)

        val builder = NotificationCompat.Builder(application, NOTIFICATION_ID)
            .setContentTitle("Debug Menu")
            .setContentText("Tap to open the debug menu ☕")
            .setContentIntent(pendingIntent)
            .setSmallIcon(android.R.drawable.sym_def_app_icon)
            .setOngoing(true)

        val notificationManager = application.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        createNotificationChannelsIfNeeded(notificationManager)
        notificationManager.notify(1337, builder.build())
    }

    private fun createNotificationChannelsIfNeeded(notificationManager: NotificationManager) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
            return
        }
        val channel = NotificationChannel(NOTIFICATION_ID, "Debug", NotificationManager.IMPORTANCE_DEFAULT).apply {
            setShowBadge(false)
        }
        notificationManager.createNotificationChannel(channel)
    }
}