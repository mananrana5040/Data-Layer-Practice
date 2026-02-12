package com.example.datalayerpractice.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.datalayerpractice.repository.CoffeeRepository
import kotlinx.coroutines.launch

class CoffeeViewModel(private val coffeeRepository: CoffeeRepository): ViewModel() {
    var _coffeeName = "No Coffee"
    var _price = "0$"



    fun orderCoffee(){
        viewModelScope.launch {
            var result= coffeeRepository.getCoffee()
            _coffeeName = result.name
            _price = result.price
        }

    }
}