package com.example.di_homework.data.repositories

import com.example.di_homework.data.api.datasource.RemoteUserDataSourceImpl
import com.example.di_homework.domain.model.UserDomain
import com.example.di_homework.domain.repository.UserRepository

class UserRepositoryImpl(
    private val remoteUsersServiceImpl: RemoteUserDataSourceImpl
) : UserRepository {
    override suspend fun getUsersList(): List<UserDomain>? =
        remoteUsersServiceImpl.loadUsersList()
}