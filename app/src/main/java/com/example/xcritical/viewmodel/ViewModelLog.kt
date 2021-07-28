package com.example.xcritical.viewmodel

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ViewModelLog @Inject constructor() : ViewModel() {

    var email = MutableLiveData<String>().apply { value = "k@g.c" }
    var password = MutableLiveData<String>().apply { value = "123" }

    private val _validEmail = MutableLiveData<Boolean>().apply { value = true }
    val validEmail: LiveData<Boolean>
    get() = _validEmail

    private val _validPassword = MutableLiveData<Boolean>().apply { value = true }
    val validPassword: LiveData<Boolean>
    get() = _validPassword

    private val _login = MutableLiveData<Boolean>()
    val login: LiveData<Boolean>
    get() = _login

    fun onLogin() {
        _validEmail.value = !email.value.isNullOrEmpty() || Patterns.EMAIL_ADDRESS.matcher(email.toString()).matches()
        _validPassword.value = !password.value.isNullOrEmpty()
        _login.value = !(email.value.isNullOrEmpty() || password.value.isNullOrEmpty())
    }
}