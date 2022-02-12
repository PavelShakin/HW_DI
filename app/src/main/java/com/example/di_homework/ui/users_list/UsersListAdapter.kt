package com.example.di_homework.ui.users_list

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
import com.example.di_homework.databinding.ItemUsersListBinding
import com.example.di_homework.domain.model.UserDomain

class UsersListAdapter : RecyclerView.Adapter<UsersListAdapter.UserViewHolder>() {

    var currentList: List<UserDomain> = emptyList()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = ItemUsersListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UsersListAdapter.UserViewHolder, position: Int) {
        currentList[position].let { holder.bind(it) }
    }

    override fun getItemCount(): Int = currentList.size

    inner class UserViewHolder(private val binding: ItemUsersListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: UserDomain) {
            with(binding) {
                txtTitle.text = item.title

                Glide.with(itemView)
                    .load(
                        GlideUrl(
                            item.photoUrl,
                            LazyHeaders.Builder().addHeader("User-Agent", "Android").build()
                        )
                    )
                    .placeholder(imgUserIcon.drawable)
                    .into(imgUserIcon)
            }
        }
    }
}