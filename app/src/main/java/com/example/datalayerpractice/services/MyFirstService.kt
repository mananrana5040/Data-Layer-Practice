package com.example.datalayerpractice.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast

class MyFirstService: Service() {

    override fun onStartCommand(
        intent: Intent?,
        flags: Int,
        startId: Int
    ): Int {
        Toast.makeText(this, "Service running", Toast.LENGTH_SHORT).show()
        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

}