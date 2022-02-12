package com.example.di_homework.domain.model

import com.squareup.moshi.Json

data class UserDomain(
    @Json(name = "id")
    var userId: Int,

    @Json(name = "title")
    var title: String,

    @Json(name = "url")
    val photoUrl: String
)