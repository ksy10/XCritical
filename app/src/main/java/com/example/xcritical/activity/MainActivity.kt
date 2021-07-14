package com.example.xcritical.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.xcritical.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val navController by lazy{ findNavController(R.id.fragmentNav)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupButtonNavMenu(navController)

    }

    private fun setupButtonNavMenu(navController: NavController) {
        val bottomNav = findViewById<BottomNavigationView>(R.id.button_nav)
        bottomNav?.setupWithNavController(navController)
    }
}