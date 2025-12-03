package com.example.demo.domain.usecase

import com.example.demo.domain.model.Car
import com.example.demo.domain.repository.CarRepository

class GetCarsUseCase(
    private val repository: CarRepository
) {
    suspend operator fun invoke(
        make: String = "",
    ): List<Car> = repository.getCars(make)
}
