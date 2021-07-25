package com.example.xcritical.usecase

import com.example.xcritical.instruments.CardInstrument
import com.example.xcritical.repository.Repository
import javax.inject.Inject

class UseCaseId @Inject constructor(private val repository: Repository) {

    fun getId(id: Int): CardInstrument {
        return repository.getId(id)
    }
}