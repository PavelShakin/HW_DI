package com.example.di_homework.ui.users_list

import android.os.Bundle
import android.view.View
import com.example.di_homework.databinding.FragmentUsersListBinding
import com.example.di_homework.ui.BaseFragment
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class FragmentUsersList :
    BaseFragment<FragmentUsersListBinding>(FragmentUsersListBinding::inflate) {

    private val viewModel: UsersListViewModel by sharedViewModel()
    private val userAdapter = UsersListAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecycler()
        viewModel.loadUsersList()

        viewModel.usersList.observe(this, {
            viewModel.usersList.value?.let {
                userAdapter.currentList = it
            }
        })
    }

    private fun setUpRecycler() {
        binding.recyclerView.apply {
            adapter = userAdapter
        }
    }
}