package com.example.xcritical.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.xcritical.R
import dagger.hilt.android.AndroidEntryPoint


class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
    }
}