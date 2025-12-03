package com.example.demo.domain.repository

import com.example.demo.domain.model.Car

interface CarRepository {
    suspend fun getCars(make: String): List<Car>
}
