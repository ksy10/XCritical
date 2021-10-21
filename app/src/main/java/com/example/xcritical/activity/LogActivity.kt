package com.example.xcritical.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.xcritical.MyService
import com.example.xcritical.R
import com.example.xcritical.customview.FragmentCustomDialog
import com.example.xcritical.databinding.ActivityLogBinding
import com.example.xcritical.viewmodel.ViewModelLog
import com.google.android.play.core.appupdate.v
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
        onRegistration()
    }

    private fun initSwitchOver() {
    viewModel.login.observe(this) {
        if(it) {
            viewModel.saveLogin()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.right_in, R.anim.left_out)
        } else {
            val dialog = FragmentCustomDialog(::onSendToast)
            dialog.show(supportFragmentManager, "customDialog")
        }
        }
    }

    private fun onSendToast() {
        Toast.makeText(this,"Попробуйте ввести данные ещё раз!", Toast.LENGTH_SHORT).show()
        binding.textErrorEmail.visibility = View.INVISIBLE
        binding.textErrorPassword.visibility = View.INVISIBLE
    }

    fun onRegistration() {
        binding.buttonSignup.setOnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }
    }
}


