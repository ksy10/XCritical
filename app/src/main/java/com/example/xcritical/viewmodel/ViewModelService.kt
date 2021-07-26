package com.example.xcritical.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.xcritical.retrofit.Movies
import com.example.xcritical.retrofit.Service
import com.example.xcritical.usecase.UseCaseRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModelService @Inject constructor(private val service: Service, private val useCaseRequest: UseCaseRequest) : ViewModel() {

    private var listMovie: MutableList<Movies>? = null

    fun getRequest() {
        viewModelScope.launch {

                useCaseRequest.createMoviesList()

        }
    }

    fun getMoviesList(): MutableList<Movies>? {
        return useCaseRequest.getMoviesList()
    }
}