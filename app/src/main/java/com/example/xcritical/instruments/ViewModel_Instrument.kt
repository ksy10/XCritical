package com.example.xcritical.instruments

import android.util.Patterns
import androidx.lifecycle.ViewModel

class ViewModel_Instrument() : ViewModel() {

    var email = ""
    var password = ""

    fun validationEmail(): Boolean {
         return (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
    }

    fun validationPassword(): Boolean {
        return password.isEmpty()
    }

    override fun onCleared() {
        super.onCleared()
    }
}