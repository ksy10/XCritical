package com.example.xcritical.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.xcritical.retrofit.Movies
import com.example.xcritical.retrofit.Service
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class ViewModelService @Inject constructor(private val service: Service) : ViewModel() {

    private lateinit var liveDataList: MutableLiveData<Movies>

    fun getLiveData(): MutableLiveData<Movies> {
        return liveDataList
    }

    fun getRequest() {
        viewModelScope.launch {
            try {
                val call = service.getMovie()
                val response = call.body()
            }
            catch (ex:Exception){
                var t = ex
            }
        }
    }
}