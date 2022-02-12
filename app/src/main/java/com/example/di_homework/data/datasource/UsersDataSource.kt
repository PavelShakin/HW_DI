package com.example.di_homework.data.datasource

import com.example.di_homework.domain.model.UserDomain

interface UsersDataSource {

    interface Remote {
        suspend fun loadUsersList(): List<UserDomain>?
    }
}