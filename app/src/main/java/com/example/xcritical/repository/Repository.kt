package com.example.xcritical.repository

import com.example.xcritical.R
import com.example.xcritical.instruments.CardInstrument
import com.example.xcritical.local.LocalApi
import javax.inject.Inject

class Repository @Inject constructor(private val localAPI: LocalApi) {

    fun getList(): ArrayList<CardInstrument>{
        return localAPI.generateList()
    }

    fun getId(id: Int): CardInstrument {
        return localAPI.getIdFromList(id)
    }

    fun getMoviesList() {

    }
}