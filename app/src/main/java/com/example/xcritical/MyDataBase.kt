package com.example.xcritical

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.xcritical.dao.IUserDao
import com.example.xcritical.entity.User

@Database(entities = arrayOf(User::class), version = 1, exportSchema = true)
abstract class MyDataBase : RoomDatabase() {
    abstract fun userDao(): IUserDao

    companion object {

        @Volatile
        private var INSTANCE: MyDataBase? = null

        fun getDatabase(context: Context): MyDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MyDataBase::class.java,
                    "user_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}