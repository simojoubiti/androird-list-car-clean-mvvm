package com.example.demo.di

import com.example.demo.data.remote.CarQueryApi
import com.example.demo.data.repository.CarRepositoryImpl
import com.example.demo.domain.repository.CarRepository
import com.example.demo.domain.usecase.GetCarsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private const val BASE_URL = "https://www.carqueryapi.com/api/0.3/"

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder().build()

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideCarQueryApi(retrofit: Retrofit): CarQueryApi =
        retrofit.create(CarQueryApi::class.java)

    @Provides
    @Singleton
    fun provideCarRepository(api: CarQueryApi): CarRepository =
        CarRepositoryImpl(api)

    @Provides
    @Singleton
    fun provideGetCarsUseCase(repository: CarRepository): GetCarsUseCase =
        GetCarsUseCase(repository)
}
