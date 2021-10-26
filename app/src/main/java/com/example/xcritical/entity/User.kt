package com.example.xcritical.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val userId: Int?,

    @ColumnInfo(name = "email") val userEmail: String?,
    @ColumnInfo(name = "password") val userPassword: String?
)
