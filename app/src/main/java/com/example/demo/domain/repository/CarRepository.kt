package com.example.demo.domain.repository
import com.example.demo.domain.model.Car

/**
 * Defines the contract for data operations related to cars.
 *
 * This interface acts as an abstraction layer for the data source. It decouples the domain
 * and presentation layers from the specific implementation of data fetching (e.g., from a
 * remote API, local database, or a combination). This allows for easier testing and maintenance,
 * as the implementation can be swapped without affecting the use cases.
 *
 * @author JOUBITI MOHAMMED
 */
interface CarRepository {

    /**
     * Retrieves a list of cars for a specific manufacturer.
     *
     * This suspending function fetches car data from a data source and maps it
     * to a list of [Car] domain models.
     *
     * @param make The manufacturer/brand to filter cars by (e.g., "Ford", "Renault").
     * @return A list of [Car] objects corresponding to the given make.
     *         Returns an empty list if no cars are found.
     * @throws Exception if there is a problem fetching the data (e.g., network error).
     */
    suspend fun getCars(make: String): List<Car>
}