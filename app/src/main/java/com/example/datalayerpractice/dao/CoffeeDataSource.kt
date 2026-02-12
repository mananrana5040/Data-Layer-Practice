package com.example.datalayerpractice.dao

import com.example.datalayerpractice.model.Coffee

class CoffeeDataSource{
    suspend fun makeCoffee(): Coffee{
        return Coffee("Black Coffee", "200$")
    }
}