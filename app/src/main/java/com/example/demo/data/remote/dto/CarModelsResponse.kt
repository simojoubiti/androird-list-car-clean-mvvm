package com.example.demo.data.remote.dto

import com.google.gson.annotations.SerializedName

/**
 * Represents the top-level response received from the Car Query API.
 *
 * This DTO wraps the list of car models returned by the network request.
 * It matches the JSON structure where the root object contains a "Models" array.
 *
 * @property models The list of [CarModel] objects parsed from the API response.
 * @author JOUBITI MOHAMMED
 */
data class CarModelsResponse(
    @SerializedName("Models")
    val models: List<CarModel>
)

/**
 * Represents a single car model entity from the API.
 *
 * This data class holds the raw data for a specific car model before it is
 * mapped to the domain layer's `Car` object.
 *
 * @property model_name The name of the car model (e.g., "Mustang", "Clio").
 *                      Mapped from the JSON field "model_name".
 * @property model_make_id The unique identifier for the car's manufacturer/make.
 *                         Mapped from the JSON field "model_make_id".
 * @author JOUBITI MOHAMMED
 */
data class CarModel(
    @SerializedName("model_name") val model_name: String,
    @SerializedName("model_make_id") val model_make_id: String
)