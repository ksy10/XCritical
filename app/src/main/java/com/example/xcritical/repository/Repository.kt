package com.example.xcritical.repository

import com.example.xcritical.R
import com.example.xcritical.instruments.CardInstrument
import com.example.xcritical.local.LocalApi
import com.example.xcritical.retrofit.Movies
import com.example.xcritical.retrofit.Service
import javax.inject.Inject

class Repository @Inject constructor(private val localAPI: LocalApi, private val service: Service) {

    private var listMovies: MutableList<Movies>? = null

    fun getList(): ArrayList<CardInstrument>{
        return localAPI.generateList()
    }

    fun getId(id: Int): CardInstrument {
        return localAPI.getIdFromList(id)
    }

    suspend fun createMoviesList() {
        listMovies = service.getMovie().body()
        localAPI.createMoviesList(listMovies)
    }

    fun getMoviesList(): MutableList<Movies>? {
        return localAPI.getListMovies()
    }
}