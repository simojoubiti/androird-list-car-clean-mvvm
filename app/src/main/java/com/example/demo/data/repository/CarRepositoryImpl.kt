package com.example.demo.data.repository
import com.example.demo.data.remote.CarQueryApi
import com.example.demo.domain.model.Car
import com.example.demo.domain.repository.CarRepository
import kotlin.random.Random

/**
 * Concrete implementation of the [CarRepository] interface.
 *
 * This class handles the data operations for retrieving car information. It acts as a
 * bridge between the remote data source ([CarQueryApi]) and the domain layer.
 * Since the remote API provides limited data, this repository enriches the domain
 * objects with simulated data (prices, descriptions, images) to provide a complete
 * UI experience.
 *
 * @property api The Retrofit service used to fetch raw car model data from the network.
 * @author JOUBITI MOHAMMED
 */
class CarRepositoryImpl(
    private val api: CarQueryApi
) : CarRepository {

    /**
     * Fetches a list of cars for a specific manufacturer.
     *
     * This function performs the following steps:
     * 1. Calls the remote API to get all models for the given [make].
     * 2. Filters the result to take only the last 6 models (to limit data size).
     * 3. Maps the raw API data (DTOs) to the domain [Car] entity.
     * 4. Generates auxiliary data (price, image, description) since the API does not provide it.
     *
     * @param make The manufacturer of the cars to retrieve (e.g., "Ford", "Renault").
     * @return A list of [Car] objects ready for use by the UI.
     */
    override suspend fun getCars(make: String): List<Car> {
        // Fetch models from the remote API for the specified make.
        val response = api.getModels(make)

        // Take the last 6 models from the response and map them to the domain 'Car' object.
        return response.models.takeLast(6).map { dto ->
            Car(
                id = dto.model_make_id,
                // Create a display name by combining ID and Model Name
                name = " ${dto.model_make_id} ${dto.model_name} ".trim(),
                make = make,
                description = buildString {
                    append("Comfortable car")
                    append(" • ")
                    append("Unknown fuel")
                },
                estimated_price = randomPrice(make),
                imageUrl = getRandomImageForBrand(make),
                fueltype = "TA1",
            )
        }
    }

    /**
     * Generates a random estimated price for a car based on its brand.
     *
     * This helper function simulates pricing data. It defines specific price ranges
     * for known brands (Renault, Ford) and a generic range for others.
     *
     * @param mark The make of the car (e.g., "renault"). Can be null.
     * @return An integer representing the generated price.
     */
    private fun randomPrice(mark: String?): Int {
        return when (mark?.lowercase()) {
            "renault" -> Random.nextInt(18000, 40000)
            "ford" -> Random.nextInt(12000, 50000)
            else -> Random.nextInt(20000, 80000)
        }
    }

    /**
     * Retrieves a random image URL appropriate for the given car brand.
     *
     * This function uses hardcoded lists of image URLs (from Pexels) categorized by brand.
     * It attempts to find the list corresponding to the provided [brand]. If the brand
     * is not found in the map, it falls back to the Renault image list.
     *
     * @param brand The brand of the car (e.g., "Ford", "Audi").
     * @return A valid URL string pointing to a car image.
     */
    private fun getRandomImageForBrand(brand: String): String {

        val renaultImages = listOf(
            "https://images.pexels.com/photos/994605/pexels-photo-994605.jpeg",
            "https://images.pexels.com/photos/170811/pexels-photo-170811.jpeg",
            "https://images.pexels.com/photos/210019/pexels-photo-210019.jpeg",
            "https://images.pexels.com/photos/358070/pexels-photo-358070.jpeg",
            "https://images.pexels.com/photos/70912/pexels-photo-70912.jpeg",
            "https://images.pexels.com/photos/112460/pexels-photo-112460.jpeg"
        )

        val fordImages = listOf(
            "https://images.pexels.com/photos/358070/pexels-photo-358070.jpeg",
            "https://images.pexels.com/photos/358070/pexels-photo-358070.jpeg",
            "https://images.pexels.com/photos/919073/pexels-photo-919073.jpeg",
            "https://images.pexels.com/photos/2335153/pexels-photo-2335153.jpeg",
            "https://images.pexels.com/photos/376724/pexels-photo-376724.jpeg",
            "https://images.pexels.com/photos/1402787/pexels-photo-1402787.jpeg"
        )

        val toyotaImages = listOf(
            "https://images.pexels.com/photos/358070/pexels-photo-358070.jpeg",
            "https://images.pexels.com/photos/210019/pexels-photo-210019.jpeg",
            "https://images.pexels.com/photos/170811/pexels-photo-170811.jpeg",
            "https://images.pexels.com/photos/358070/pexels-photo-358070.jpeg",
            "https://images.pexels.com/photos/919073/pexels-photo-919073.jpeg",
            "https://images.pexels.com/photos/112460/pexels-photo-112460.jpeg"
        )

        val fiatImages = listOf(
            "https://images.pexels.com/photos/1402787/pexels-photo-1402787.jpeg",
            "https://images.pexels.com/photos/244132/pexels-photo-244132.jpeg",
            "https://images.pexels.com/photos/919073/pexels-photo-919073.jpeg",
            "https://images.pexels.com/photos/2335153/pexels-photo-2335153.jpeg",
            "https://images.pexels.com/photos/1402787/pexels-photo-1402787.jpeg",
            "https://images.pexels.com/photos/70912/pexels-photo-70912.jpeg"
        )

        val audiImages = listOf(
            "https://images.pexels.com/photos/358070/pexels-photo-358070.jpeg",
            "https://images.pexels.com/photos/919073/pexels-photo-919073.jpeg",
            "https://images.pexels.com/photos/358070/pexels-photo-358070.jpeg",
            "https://images.pexels.com/photos/112460/pexels-photo-112460.jpeg",
            "https://images.pexels.com/photos/170811/pexels-photo-170811.jpeg",
            "https://images.pexels.com/photos/358070/pexels-photo-358070.jpeg"
        )

        // A map linking car brands to their respective list of image URLs.
        val map = mapOf(
            "Renault" to renaultImages,
            "Ford" to fordImages,
            "Toyota" to toyotaImages,
            "Fiat" to fiatImages,
            "Audi" to audiImages
        )

        // Return a shuffled image from the brand's list, or a default one if the brand is not found.
        return map[brand]?.shuffled()?.first()
            ?: renaultImages.shuffled().first()
    }
}