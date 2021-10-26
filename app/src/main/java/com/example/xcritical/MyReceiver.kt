package com.example.xcritical

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        val isAirplaneModeEnabled = intent.getBooleanExtra("state", false)
        if (isAirplaneModeEnabled) {
            Toast.makeText(context, Const.ACTION_NOTIFICATION_ON, Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(context, Const.ACTION_NOTIFICATION_OFF, Toast.LENGTH_LONG).show()
        }
    }
}