package com.example.datalayerpractice.repository

import com.example.datalayerpractice.dao.CoffeeDataSource
import com.example.datalayerpractice.model.Coffee

class CoffeeRepository(private val coffeeDataSource: CoffeeDataSource) {
    suspend fun getCoffee(): Coffee{
        return coffeeDataSource.makeCoffee()
    }
}