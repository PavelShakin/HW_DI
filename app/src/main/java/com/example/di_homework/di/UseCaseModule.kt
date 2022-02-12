package com.example.di_homework.di

import com.example.di_homework.domain.usecases.LoadUsersListUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory {
        LoadUsersListUseCase(get())
    }
}