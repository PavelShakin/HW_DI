package com.example.di_homework.domain.repository

import com.example.di_homework.domain.model.UserDomain

interface UserRepository {
    suspend fun getUsersList(): List<UserDomain>?
}