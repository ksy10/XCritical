package com.example.xcritical.usecase

import com.example.xcritical.repository.Repository
import com.example.xcritical.retrofit.Movies
import javax.inject.Inject

class UseCaseRequest @Inject constructor(private val repository: Repository) {

    suspend fun createMoviesList() {
        repository.createMoviesList()
    }

    fun getMoviesList(): MutableList<Movies>? {
        return repository.getMoviesList()
    }
}