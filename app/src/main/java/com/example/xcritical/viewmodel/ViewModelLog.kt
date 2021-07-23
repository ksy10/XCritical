package com.example.xcritical.viewmodel

import android.util.Patterns
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ViewModelLog @Inject constructor() : ViewModel() {

    var email = ""
    var password = ""

    fun validationEmail(): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun validationPassword(): Boolean {
        return password.isNotEmpty()
    }
}