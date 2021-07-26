package com.example.xcritical.local

import com.example.xcritical.instruments.CardInstrument
import com.example.xcritical.retrofit.Movies
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalApi @Inject constructor() {

    private var list = ArrayList<CardInstrument>()
    private var movies: MutableList<Movies>? = null

    fun generateList(): ArrayList<CardInstrument> {
       if (list.isNullOrEmpty()) {
           createdList()
       }
        return list
    }

    fun getIdFromList(id: Int): CardInstrument {
        return list.filter { it.id == id }[0]
    }

    private fun createdList() {
        for (i in 0 until 20) {
            val item = CardInstrument(i,"AUD","/","JPY","73,5670","/","73,5940","0,03%")
            list += item
        }
    }

    fun createMoviesList(listMovies: MutableList<Movies>?) {
        movies = listMovies
    }

    fun getListMovies(): MutableList<Movies>? {
        return movies
    }
}