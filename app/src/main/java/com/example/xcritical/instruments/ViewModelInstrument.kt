package com.example.xcritical.instruments

import android.util.Patterns
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.xcritical.R

class ViewModelInstrument() : ViewModel() {

    private val Email = MutableLiveData<String>()
    private val Password = MutableLiveData<String>()
    val Login = MutableLiveData<Boolean>()
    var email = ""
    var password = ""

    init {
        Email.value = ""
        Password.value = ""
    }

    fun validationEmail(): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun validationPassword(): Boolean {
        return password.isNotEmpty()
    }

    fun generateList(size: Int): ArrayList<CardInstrument> {
        val list = ArrayList<CardInstrument>()
        for (i in 0 until size) {
            val draw = when (i%2) {
                0 -> R.drawable.ic_default_icon_currency
                else -> R.drawable.ic_star
            }
            val item = CardInstrument(i,"AUD","/","JPY","73,5670","/","73,5940","0,03%")
            list += item
        }
        return list
    }

    override fun onCleared() {
        super.onCleared()
    }
}