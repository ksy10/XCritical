package com.example.xcritical.instruments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.xcritical.R
import com.example.xcritical.databinding.MoviesItemBinding
import com.example.xcritical.entity.User

class UserAdapter(private val listUser: List<User>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = UserViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.movies_item,
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bindingUser.user = listUser[position]
        holder.bind(listUser[position])
    }

    override fun getItemCount(): Int = listUser.size

    class UserViewHolder(val bindingUser : MoviesItemBinding): RecyclerView.ViewHolder(bindingUser.root) {

        fun bind(item: User) {
            bindingUser.name.text = item.userEmail
            bindingUser.realname.text = item.userPassword
        }
    }
}