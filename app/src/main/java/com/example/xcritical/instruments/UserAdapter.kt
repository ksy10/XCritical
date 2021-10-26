package com.example.xcritical.instruments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.xcritical.databinding.MoviesItemBinding
import com.example.xcritical.entity.User

class UserAdapter(private val listUser: List<User>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = MoviesItemBinding.inflate(inflater)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(listUser[position])
    }

    override fun getItemCount(): Int = listUser.size

    class UserViewHolder(private val binding : MoviesItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(item: User) {
            binding.name.text = item.userEmail
            binding.realname.text = item.userPassword
        }
    }
}