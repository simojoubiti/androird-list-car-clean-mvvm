package com.example.demo.data.remote.dto

import com.google.gson.annotations.SerializedName

data class CarModelsResponse(
    @SerializedName("Models")
    val models: List<CarModel>
)

data class CarModel(
    @SerializedName("model_name") val model_name: String,
    @SerializedName("model_make_id") val model_make_id: String
)
