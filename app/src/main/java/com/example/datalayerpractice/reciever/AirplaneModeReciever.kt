package com.example.datalayerpractice.reciever

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AirplaneModeReciever: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val isAirplaneModeEnabled = intent?.getBooleanExtra("state", false) ?: false
        if (isAirplaneModeEnabled) {
            Toast.makeText(context, "Airplane Mode is ON", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(context, "Airplane Mode is OFF", Toast.LENGTH_LONG).show()
        }
    }
}