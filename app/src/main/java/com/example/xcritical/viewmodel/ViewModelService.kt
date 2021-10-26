package com.example.xcritical.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.xcritical.MyDataBase
import com.example.xcritical.entity.User
import com.example.xcritical.repository.DataBaseRepository
import com.example.xcritical.usecase.UseCaseRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class ViewModelService @Inject constructor(
    private val useCaseRequest: UseCaseRequest
) : ViewModel() {




    //var textListener = MutableLiveData<String>()

    /*fun getRequest() {
        viewModelScope.launch {
            useCaseRequest.createMoviesList()
        }
    }*/

    /*fun getMoviesList(): MutableList<Movies>? {
        return useCaseRequest.getMoviesList()
    }

    fun setMoviesListForFilter(text: String): MutableList<Movies>? {
        return useCaseRequest.filteredListMovies(text)
    }*/

}