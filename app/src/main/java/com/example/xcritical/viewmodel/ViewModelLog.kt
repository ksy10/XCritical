package com.example.xcritical.viewmodel

import android.app.Application
import android.util.Patterns
import androidx.lifecycle.*
import com.example.xcritical.MyDataBase
import com.example.xcritical.entity.User
import com.example.xcritical.repository.DataBaseRepository
import com.example.xcritical.repository.PreferenceHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModelLog @Inject constructor(
    private val preferenceHelper: PreferenceHelper
) : ViewModel() {

    var email = MutableLiveData<String>()
    var password = MutableLiveData<String>()

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
        _validEmail.value =
            !email.value.isNullOrEmpty() || Patterns.EMAIL_ADDRESS.matcher(email.toString())
                .matches()
        _validPassword.value = !password.value.isNullOrEmpty()
        _login.value = !(email.value.isNullOrEmpty() || password.value.isNullOrEmpty())
    }

    fun saveLogin() {
        viewModelScope.launch {
            preferenceHelper.addProperty("email", email.value.toString())
            preferenceHelper.addProperty("password", password.value.toString())
        }
    }

    fun getProperty() {
        email.value = preferenceHelper.getProperty("email")
        password.value = preferenceHelper.getProperty("password")
    }
}