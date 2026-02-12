package com.example.datalayerpractice.repository

import com.example.datalayerpractice.api.UserApi
import com.example.datalayerpractice.dao.UserDao
import com.example.datalayerpractice.model.User
import com.example.datalayerpractice.model.UserEntity
import javax.inject.Inject

class UserRepository @Inject constructor(private val userDao: UserDao, private val userApi: UserApi) {

    suspend fun getUserById(userId: Int): User{
        val localUser = userDao.getUsersById(userId)
        if (localUser != null) {
            return User(localUser.id, localUser.name, localUser.email)
        } else {
            val remoteUser = userApi.getUser(userId)
            userDao.insertUser(UserEntity(remoteUser.id, remoteUser.name, remoteUser.email))
            return remoteUser
        }
    }
}