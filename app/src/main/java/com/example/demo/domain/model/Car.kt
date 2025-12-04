package com.example.demo.domain.model
/**
 * Domain model representing a Car entity.
 *
 * This class holds the core business data for a vehicle. It acts as the single source of truth
 * for the UI layer, decoupled from the raw network responses (DTOs). It contains all necessary
 * information to display a car card in the application list.
 *
 * @property id The unique identifier for the car model.
 * @property name The full display name of the car (often a combination of ID and model name).
 * @property description A brief text description highlighting features or condition.
 * @property make The manufacturer or brand of the car (e.g., "Ford", "Renault").
 * @property imageUrl A URL string pointing to a visual representation of the car.
 * @property fueltype The code or name representing the type of fuel used (e.g., "TA1").
 * @property estimated_price The generated estimated cost of the vehicle.
 * @author JOUBITI MOHAMMED
 */
data class Car(
    val id: String,
    val name: String,
    val description: String,
    val make: String,
    val imageUrl: String,
    val fueltype: String,
    val estimated_price: Int
)