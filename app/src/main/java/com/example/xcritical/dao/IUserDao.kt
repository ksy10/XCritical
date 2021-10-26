package com.example.xcritical.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.xcritical.entity.User
import dagger.Provides

@Dao
interface IUserDao {
    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun getAllUser(): List<User>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insetUser(user: User)
}