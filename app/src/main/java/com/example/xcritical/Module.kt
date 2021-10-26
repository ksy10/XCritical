package com.example.xcritical

import android.content.Context
import com.example.xcritical.dao.IUserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class Module {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): MyDataBase {
        return MyDataBase.getDatabase(context)
    }

    @Provides
    fun providePlantDao(appDatabase: MyDataBase): IUserDao {
        return appDatabase.userDao()
    }
}