package com.example.cooke

import android.app.Application
import android.util.Log

class CookE : Application() {
    override fun onCreate() {
        super.onCreate()

        Log.d("CookE", "App started")
    }
}
