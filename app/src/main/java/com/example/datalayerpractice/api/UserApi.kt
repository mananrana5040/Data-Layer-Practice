package com.example.datalayerpractice.api

import com.example.datalayerpractice.model.User
import retrofit2.http.GET
import retrofit2.http.Path

interface UserApi {
    @GET("users/{id}")
    suspend fun getUser(@Path("id") userId: Int): User
}