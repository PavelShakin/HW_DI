package com.example.di_homework.di

import com.example.di_homework.ui.users_list.UsersListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        UsersListViewModel(get())
    }
}