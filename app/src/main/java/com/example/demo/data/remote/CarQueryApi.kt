package com.example.demo.data.remote

import com.example.demo.data.remote.dto.CarModelsResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Retrofit interface definition for the Car Query API.
 *
 * This interface defines the network endpoints used to retrieve car-related data
 * from the remote web service. Retrofit automatically generates the implementation
 * of this interface at runtime.
 *
 * @author JOUBITI MOHAMMED
 */
interface CarQueryApi {

    /**
     * Retrieves a list of car models for a specific manufacturer.
     *
     * This function performs a GET request to the base URL with the command parameter `?cmd=getModels`
     * and appends the specific manufacturer query.
     *
     * Example URL generated: `https://api.example.com/?cmd=getModels&make=ford`
     *
     * @param make The manufacturer/brand to filter models by (e.g., "ford", "renault", "toyota").
     *             This value is URL-encoded automatically by Retrofit.
     * @return A [CarModelsResponse] object containing the list of models returned by the API.
     * @throws retrofit2.HttpException If the server responds with a non-2xx status code.
     * @throws java.io.IOException If a network error occurs (e.g., no internet connection).
     */
    @GET("?cmd=getModels")
    suspend fun getModels(
        @Query("make") make: String
    ): CarModelsResponse
}