package com.example.xcritical.viewmodel

import androidx.lifecycle.ViewModel
import com.example.xcritical.instruments.CardInstrument
import com.example.xcritical.instruments.CardInstrumentWithImage
import com.example.xcritical.usecase.UseCaseInstrument
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ViewModelInstrument @Inject constructor(private val useCaseInstrument: UseCaseInstrument) : ViewModel() {

    fun getList(): ArrayList<CardInstrumentWithImage> {
        return useCaseInstrument.getList()
    }

    override fun onCleared() {
        super.onCleared()
    }
}