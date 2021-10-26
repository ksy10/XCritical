package com.example.xcritical.viewmodel

import androidx.lifecycle.LiveData
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
class DataViewModel @Inject constructor(private val dataBaseRepository: DataBaseRepository,) : ViewModel() {

    var user: List<User>?= null
    var email = MutableLiveData<String>()
    var password = MutableLiveData<String>()

    init {
        getUsers()
    }

    fun getUsers(): List<User>? {
        viewModelScope.launch(Dispatchers.IO) {
            //withContext(Dispatchers.IO) {
                user = dataBaseRepository.getUsers()
                //delay(5000000)
            }
        //}
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