package com.example.demo.data.remote


import com.example.demo.data.remote.dto.CarModelsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CarQueryApi {

    @GET("?cmd=getModels")
    suspend fun getModels(
        @Query("make") make: String
    ): CarModelsResponse
}
