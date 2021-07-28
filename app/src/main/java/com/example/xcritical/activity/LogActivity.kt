package com.example.xcritical.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.xcritical.R
import com.example.xcritical.databinding.ActivityLogBinding
import com.example.xcritical.viewmodel.ViewModelLog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LogActivity : AppCompatActivity() {
    private val viewModel by lazy { ViewModelProvider(this).get(ViewModelLog::class.java) }
    private lateinit var binding: ActivityLogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_log)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        viewModel.getProperty()
        initSwitchOver()
    }

    private fun initSwitchOver() {
    viewModel.login.observe(this) {
        if(it) {
            viewModel.saveLogin()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
    }
}


