package com.example.di_homework.domain.usecases

import com.example.di_homework.domain.repository.UserRepository

class LoadUsersListUseCase(private val moviesListRepository: UserRepository) {

    suspend fun loadItemList() = moviesListRepository.getUsersList()
}