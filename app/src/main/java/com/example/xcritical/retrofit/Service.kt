package com.example.xcritical.retrofit

import retrofit2.Response
import retrofit2.http.GET

interface Service {
    @GET("marvel")
    suspend fun getMovie(): Response<Movies>
}