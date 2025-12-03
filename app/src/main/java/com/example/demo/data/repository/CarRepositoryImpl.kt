package com.example.demo.data.repository

import com.example.demo.data.remote.CarQueryApi
import com.example.demo.domain.model.Car
import com.example.demo.domain.repository.CarRepository
import kotlin.random.Random

class CarRepositoryImpl(
    private val api: CarQueryApi
) : CarRepository {

    override suspend fun getCars(make: String): List<Car> {
        val response = api.getModels(make)
        return response.models.takeLast(6).map { dto ->
            Car(
                id = dto.model_make_id,
                name = " ${dto.model_make_id} ${dto.model_name} ".trim(),
                make = make,

                description = buildString {
                    append("Comfortable car")
                    append(" • ")
                    append( "Unknown fuel")
                },
                estimated_price = randomPrice(make),
                imageUrl = getRandomImageForBrand(make),
                fueltype   = "TA1",

            )
        }
    }

    private fun randomPrice(mark: String?): Int {
        return when (mark?.lowercase()) {
            "renault" -> Random.nextInt(18000, 40000)
            "ford" -> Random.nextInt(12000, 50000)

            else -> Random.nextInt(20000, 80000)
        }
    }
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

        val map = mapOf(
            "Renault" to renaultImages,
            "Ford" to fordImages,
            "Toyota" to toyotaImages,
            "Fiat" to fiatImages,
            "Audi" to audiImages
        )

        // always return non-repetitive random link
        return map[brand]?.shuffled()?.first()
            ?: renaultImages.shuffled().first()
    }


}
