package com.example.di_homework.ui.users_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.di_homework.domain.model.UserDomain
import com.example.di_homework.domain.usecases.LoadUsersListUseCase
import kotlinx.coroutines.launch

class UsersListViewModel(private val useCase: LoadUsersListUseCase) : ViewModel() {

    private val _usersList = MutableLiveData<List<UserDomain>>()
    val usersList: LiveData<List<UserDomain>> = _usersList

    fun loadUsersList() {
        viewModelScope.launch {
            _usersList.postValue(useCase.loadItemList())
        }
    }
}