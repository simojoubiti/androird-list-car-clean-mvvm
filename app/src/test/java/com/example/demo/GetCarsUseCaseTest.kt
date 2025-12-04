package com.example.demo
import com.example.demo.domain.model.Car
import com.example.demo.domain.repository.CarRepository
import com.example.demo.domain.usecase.GetCarsUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * A fake implementation of [CarRepository] used exclusively for testing.
 *
 * This class helps isolate the Use Case from external data sources (like network or database)
 * by providing static, predictable data. This is known as a "Stub" in testing terminology.
 * It allows us to test the Use Case logic without making actual API calls.
 */
class FakeCarRepository : CarRepository {
    /**
     * Simulates fetching cars by returning a hardcoded list containing a single Peugeot 3008.
     *
     * @param make The car manufacturer (ignored in this fake implementation).
     * @return A static list of [Car] objects.
     */
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

/**
 * Unit tests for [GetCarsUseCase].
 *
 * This class verifies that the use case correctly interacts with the repository
 * and returns the expected domain models. It uses a [FakeCarRepository] to simulate data retrieval,
 * ensuring the test is fast, deterministic, and does not require an internet connection.
 *
 * @author JOUBITI MOHAMMED
 */
@OptIn(ExperimentalCoroutinesApi::class)
class GetCarsUseCaseTest {

    // Initialize the fake repository and the Use Case under test
    private val repository = FakeCarRepository()
    private val useCase = GetCarsUseCase(repository)

    /**
     * Verifies that invoking the use case returns the list of cars provided by the repository.
     *
     * Checks performed:
     * 1. The size of the returned list is 1 (matching the fake data).
     * 2. The name of the first car matches "Peugeot 3008".
     */
    @Test
    fun `invoke returns list of cars`() = runTest {
        val cars = useCase()
        assertEquals(1, cars.size)
        assertEquals("Peugeot 3008", cars.first().name)
    }
}