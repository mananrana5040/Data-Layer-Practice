package com.example.datalayerpractice.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.datalayerpractice.dao.UserDao
import com.example.datalayerpractice.model.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}