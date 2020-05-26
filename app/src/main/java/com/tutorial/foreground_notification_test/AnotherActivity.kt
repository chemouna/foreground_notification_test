package com.tutorial.foreground_notification_test

import android.app.Activity
import android.os.Bundle

class AnotherActivity: Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.another_layout)
    }
}