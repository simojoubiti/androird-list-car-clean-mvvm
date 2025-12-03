package com.example.demo

import com.example.demo.domain.model.Car
import com.example.demo.domain.usecase.GetCarsUseCase
import com.example.demo.presentation.carlist.CarListUiState
import com.example.demo.presentation.carlist.CarListViewModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class CarListViewModelTest {

    private val dispatcher = StandardTestDispatcher()
    private lateinit var viewModel: CarListViewModel
    private val getCarsUseCase: GetCarsUseCase = mockk()

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)

        coEvery { getCarsUseCase(any()) } returns listOf(
            Car(
                id = "1",
                name = "Test Car",
                make = "test",
                description = "desc",
                fueltype = "tezx",
                estimated_price = 233333,
                imageUrl = "https://example.com/img.jpg"
            )
        )

        viewModel = CarListViewModel(getCarsUseCase)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `initial state eventually becomes Success`() = runTest {
        dispatcher.scheduler.advanceUntilIdle()
        assertTrue(viewModel.uiState.value is CarListUiState.Success)
    }
}
