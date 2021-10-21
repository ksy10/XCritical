package com.example.xcritical

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder

class MyService : Service() {
    private var _media = MediaPlayer()

    override fun onBind(intent: Intent): IBinder {
        throw UnsupportedOperationException("Not yet implemented")
    }

    override fun onCreate() {
        _media = MediaPlayer.create(this, R.raw.joey_trap_kg_smokey)
        _media.isLooping = true
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        _media.start();
        return START_STICKY
    }

    override fun onDestroy() {
        _media.stop()
    }
}