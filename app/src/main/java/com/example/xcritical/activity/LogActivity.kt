package com.example.xcritical.activity

import android.app.NotificationManager
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.xcritical.MyReceiver
import com.example.xcritical.R
import com.example.xcritical.customview.FragmentCustomDialog
import com.example.xcritical.databinding.ActivityLogBinding
import com.example.xcritical.viewmodel.ViewModelLog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LogActivity : AppCompatActivity() {
    private val viewModel by lazy { ViewModelProvider(this).get(ViewModelLog::class.java) }
    private val receiver = MyReceiver()
    private lateinit var binding: ActivityLogBinding

    companion object {
        const val NOTIFICATION_ID = 101
        const val CHANNEL_ID = "channelID"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_log)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        viewModel.getProperty()
        initSwitchOver()
        onRegistration()
        initMessage()
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(receiver)
    }

    private fun initNotification() {
        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_users)
            .setContentTitle("Notification")
            .setContentText("Katya, welcome!")
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        with(NotificationManagerCompat.from(this)) {
            notify(NOTIFICATION_ID, builder.build())
        }
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

    private fun initMessage() {
        val filter = IntentFilter()
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        registerReceiver(receiver, filter)
    }

    private fun onSendToast() {
        Toast.makeText(this,"Попробуйте ввести данные ещё раз!", Toast.LENGTH_SHORT).show()
        binding.textErrorEmail.visibility = View.INVISIBLE
        binding.textErrorPassword.visibility = View.INVISIBLE
    }

    fun onRegistration() {
        binding.buttonSignup.setOnClickListener {
            initNotification()
            val intent = Intent(this, DataActivity::class.java)
            startActivity(intent)
        }
    }
}


