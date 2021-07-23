package com.example.xcritical.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModelService @Inject constructor() : ViewModel() {

//    private lateinit var liveDataList: MutableLiveData<Movies>
//
//
//    fun getLiveData(): MutableLiveData<Movies> {
//        return liveDataList
//    }

    fun getRequest() {
        var t = 5
//        viewModelScope.launch {
//            val call: Response<Movies> = service.getMovie()
//            val response = call.body()
//        }
    }
}