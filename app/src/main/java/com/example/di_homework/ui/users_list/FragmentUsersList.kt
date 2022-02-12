package com.example.di_homework.ui.users_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.di_homework.R
import com.example.di_homework.databinding.FragmentUsersListBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class FragmentUsersList : Fragment(R.layout.fragment_users_list) {

    private lateinit var binding: FragmentUsersListBinding
    private val viewModel: UsersListViewModel by sharedViewModel()
    private val userAdapter = UsersListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUsersListBinding.inflate(inflater, container, false)
        return binding.root
    }

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