package com.example.datalayerpractice.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.datalayerpractice.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val userRepository: UserRepository): ViewModel() {

    fun getUser(userId: Int) = liveData{
        val user = userRepository.getUserById(userId)
        emit(user)
    }
}