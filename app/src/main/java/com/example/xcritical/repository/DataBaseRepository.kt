package com.example.xcritical.repository

import com.example.xcritical.dao.IUserDao
import com.example.xcritical.entity.User
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataBaseRepository @Inject constructor(private val userDao: IUserDao) {

    fun getUsers() = userDao.getAllUser()

    fun addUser(user: User) {
        userDao.insetUser(user)
    }
}