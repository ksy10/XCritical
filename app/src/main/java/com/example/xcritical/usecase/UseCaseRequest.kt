package com.example.xcritical.usecase

import com.example.xcritical.repository.Repository
import com.example.xcritical.retrofit.Movies
import com.example.xcritical.viewmodel.ViewModelService
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

class UseCaseRequest @Inject constructor(private val repository: Repository) {

    private var filterMovies: MutableList<Movies>? = null

    suspend fun createMoviesList() {
        repository.createMoviesList()
    }

    fun getMoviesList(): MutableList<Movies>? {
        return repository.getMoviesList()
    }

   fun filteredListMovies(searchText: String): MutableList<Movies>? {
       val movies = repository.getMoviesList()
       filterMovies = if (searchText.isEmpty()) {
           movies
       } else {
           val resultFiltered = ArrayList<Movies>()
           for (movie in movies!!) {
               if (movie.name?.lowercase(Locale.ROOT)!!.contains(searchText.lowercase(Locale.ROOT))) {
                   resultFiltered.add(movie)
               }
           }
           resultFiltered
       }
       return filterMovies
   }
}