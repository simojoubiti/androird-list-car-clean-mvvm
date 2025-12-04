package com.example.demo.domain.usecase
import com.example.demo.domain.model.Car
import com.example.demo.domain.repository.CarRepository

/**
 * Use case responsible for retrieving a list of cars.
 *
 * In Clean Architecture, use cases represent a specific business action or user story.
 * This class encapsulates the logic required to fetch cars from the repository,
 * acting as an intermediary between the ViewModel and the Repository.
 *
 * @property repository The data source interface used to fetch car information.
 * @author JOUBITI MOHAMMED
 */
class GetCarsUseCase(
    private val repository: CarRepository
) {

    /**
     * Executes the use case to fetch cars.
     *
     * The `operator fun invoke` allows this class to be called as if it were a function.
     * For example: `getCarsUseCase("Ford")`.
     *
     * @param make The manufacturer of the cars to retrieve. Defaults to an empty string.
     * @return A list of [Car] objects corresponding to the specified make.
     * @throws Exception Propagates any errors from the repository (e.g., network issues).
     */
    suspend operator fun invoke(
        make: String = "",
    ): List<Car> = repository.getCars(make)
}