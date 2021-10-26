package com.example.xcritical.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.xcritical.entity.User
import com.example.xcritical.repository.DataBaseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class DataViewModel @Inject constructor(private val dataBaseRepository: DataBaseRepository) :
    ViewModel() {

    var user: List<User>? = null
    var email = MutableLiveData<String>()
    var password = MutableLiveData<String>()

    init {
        getUsers()
    }

    private fun getUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            user = dataBaseRepository.getUsers()
            delay(5000000)
        }
    }

    fun initGetList(): List<User>? {
        return user
    }

    fun insertUser() {
        val user = User(
            0,
            email.value,
            password.value
        )
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                dataBaseRepository.addUser(user)
                delay(5000000)
            }
        }
    }
}