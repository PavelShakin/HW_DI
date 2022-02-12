package com.example.di_homework.di

import com.example.di_homework.data.api.datasource.RemoteUserDataSourceImpl
import com.example.di_homework.data.repositories.UserRepositoryImpl
import com.example.di_homework.domain.repository.UserRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<UserRepository> {
        UserRepositoryImpl(get())
    }
}

val dataSourceModule = module {
    single {
        RemoteUserDataSourceImpl(get())
    }
}