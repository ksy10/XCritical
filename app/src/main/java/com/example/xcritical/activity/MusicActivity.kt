package com.example.xcritical.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.xcritical.MyService
import com.example.xcritical.R
import com.example.xcritical.databinding.ActivityMusicBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MusicActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMusicBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_music)
        binding.lifecycleOwner = this
        initMusic()
    }

    private fun initMusic() {
        binding.buttonPlay.setOnClickListener {
            val i = Intent(this, MyService::class.java)
            startService(i)
        }

        binding.buttonStop.setOnClickListener {
            val i = Intent(this, MyService::class.java)
            stopService(i)
        }
    }
}