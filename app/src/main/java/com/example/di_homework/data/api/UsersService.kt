package com.example.di_homework.data.api

import com.example.di_homework.domain.model.UserDomain
import retrofit2.Response
import retrofit2.http.GET

interface UsersService {

    @GET("photos")
    suspend fun getUsers(): Response<List<UserDomain>>
}