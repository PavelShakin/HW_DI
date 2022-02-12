package com.example.di_homework.data.api.datasource

import com.example.di_homework.data.api.UsersService
import com.example.di_homework.data.datasource.UsersDataSource
import com.example.di_homework.domain.model.UserDomain

class RemoteUserDataSourceImpl(
    private val service: UsersService
) : UsersDataSource.Remote {
    override suspend fun loadUsersList(): List<UserDomain>? =
        service.getUsers().body()
}