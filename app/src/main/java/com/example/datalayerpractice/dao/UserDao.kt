package com.example.datalayerpractice.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.datalayerpractice.model.User
import com.example.datalayerpractice.model.UserEntity

@Dao
interface UserDao {
    @Insert
    suspend fun insertUser(user: UserEntity)

    @Query("SELECT * FROM users WHERE id = :userId")
    suspend fun getUsersById(userId: Int): UserEntity?
}