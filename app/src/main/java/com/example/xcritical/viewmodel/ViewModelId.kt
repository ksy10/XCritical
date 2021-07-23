package com.example.xcritical.viewmodel

import androidx.lifecycle.ViewModel
import com.example.xcritical.instruments.CardInstrument
import com.example.xcritical.usecase.UseCaseId
import com.example.xcritical.usecase.UseCaseInstrument
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ViewModelId  @Inject constructor(private val useCaseId: UseCaseId) : ViewModel() {

    fun getId(Id: Int): CardInstrument {
        return useCaseId.getId(Id)
    }
}