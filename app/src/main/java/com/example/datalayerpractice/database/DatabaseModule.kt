package com.example.datalayerpractice.database

import android.content.Context
import androidx.room.Room
import com.example.datalayerpractice.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideUserDatabase(@ApplicationContext context: Context): UserDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            UserDatabase::class.java,
            "user_database"
        ).build()
    }

    @Provides
    fun provideUserDao(userDatabase: UserDatabase): UserDao {
        return userDatabase.userDao()
    }
}