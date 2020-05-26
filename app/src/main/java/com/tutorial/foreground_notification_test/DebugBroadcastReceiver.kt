package com.tutorial.foreground_notification_test

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class DebugBroadcastReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val toolsIntent = Intent(context, ToolsActivity::class.java)
        toolsIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        context.startActivity(toolsIntent)
    }
}