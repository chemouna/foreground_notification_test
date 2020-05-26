package com.tutorial.foreground_notification_test

import android.app.Application

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            DebugMenu.init(this)
        }
    }

}