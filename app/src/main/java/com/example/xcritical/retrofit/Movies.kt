package com.example.xcritical.retrofit

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Movies(
    val name: String?,
    val realname: String?,
    val team: String?,
    val firstappearance: String?,
    val createdby: String?,
    val publisher: String?,
    val imageurl: String?,
    val bio: String?
)