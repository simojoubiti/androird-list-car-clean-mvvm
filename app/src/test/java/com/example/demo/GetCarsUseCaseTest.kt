package com.example.demo

import com.example.demo.domain.model.Car
import com.example.demo.domain.repository.CarRepository
import com.example.demo.domain.usecase.GetCarsUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class FakeCarRepository : CarRepository {
    override suspend fun getCars(make: String) =
        listOf(
            Car(
                id = "1",
                name = "Peugeot 3008",
                make = "peugeot",

                description = "SUV",
                estimated_price = 100,
                imageUrl = "https://example.com/car.jpg",
                fueltype = "test",

            )
        )
}

@OptIn(ExperimentalCoroutinesApi::class)
class GetCarsUseCaseTest {

    private val repository = FakeCarRepository()
    private val useCase = GetCarsUseCase(repository)

    @Test
    fun `invoke returns list of cars`() = runTest {
        val cars = useCase()
        assertEquals(1, cars.size)
        assertEquals("Peugeot 3008", cars.first().name)
    }
}
