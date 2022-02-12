package com.example.di_homework.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.di_homework.R
import com.example.di_homework.databinding.ActivityMainBinding
import com.example.di_homework.ui.users_list.FragmentUsersList

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setDefaultFragment()
    }

    private fun setDefaultFragment() {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.fragmentContainer, FragmentUsersList())
        }
    }
}