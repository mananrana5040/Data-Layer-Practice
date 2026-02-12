package com.example.datalayerpractice.retrofit

import com.example.datalayerpractice.api.UserApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitInstanse {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val userApi: UserApi = retrofit.create(UserApi::class.java)
}