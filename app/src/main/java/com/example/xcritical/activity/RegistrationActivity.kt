package com.example.xcritical.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.xcritical.R
import com.example.xcritical.databinding.ActivityLogBinding
import com.example.xcritical.databinding.ActivityRegistrationBinding
import com.example.xcritical.spinner.AdapterCountiesNumbers
import com.example.xcritical.spinner.CountriesNumbers
import com.example.xcritical.spinner.CountriesNumbers.Countries.list
import com.example.xcritical.viewmodel.ViewModelLog
import com.example.xcritical.viewmodel.ViewModelRegistration

class RegistrationActivity : AppCompatActivity() {
    private val viewModel by lazy { ViewModelProvider(this).get(ViewModelRegistration::class.java) }
    private lateinit var binding: ActivityRegistrationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_registration)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        initRegistration()
        setSpinner()
    }

    private fun initRegistration() {
        viewModel.registration.observe(this) {
            if (it) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun setSpinner() {
        val adapter = AdapterCountiesNumbers(this, CountriesNumbers.Countries.list)
        binding.spinnerNumber.adapter = adapter
    }
}