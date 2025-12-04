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

/**
 * Unit tests for the [CarListViewModel].
 *
 * This class verifies the logic of the ViewModel, specifically how it interacts with the
 * [GetCarsUseCase] and updates its UI state. It uses MockK for mocking dependencies
 * and kotlinx-coroutines-test to handle coroutine execution in a deterministic way.
 *
 * @author JOUBITI MOHAMMED
 */
@OptIn(ExperimentalCoroutinesApi::class)
class CarListViewModelTest {

    // A test dispatcher that allows us to control the execution of coroutines explicitly.
    private val dispatcher = StandardTestDispatcher()

    // The class under test
    private lateinit var viewModel: CarListViewModel

    // Mocked dependency for the use case
    private val getCarsUseCase: GetCarsUseCase = mockk()

    /**
     * Sets up the test environment before each test.
     *
     * 1. Replaces the Main dispatcher with our test dispatcher to run coroutines locally.
     * 2. Defines the behavior of the mocked [GetCarsUseCase] to return a predefined list of cars.
     * 3. Initializes the [CarListViewModel] with the mocked dependency.
     */
    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)

        // Define mock behavior: when getCarsUseCase is called, return a list containing one dummy car.
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

    /**
     * Cleans up the test environment after each test.
     *
     * Resets the Main dispatcher to its original state to avoid affecting other tests.
     */
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    /**
     * Verifies that the ViewModel's initial state eventually transitions to [CarListUiState.Success].
     *
     * Since the ViewModel launches a coroutine to fetch data immediately upon initialization (or shortly after),
     * we use [dispatcher.scheduler.advanceUntilIdle()] to ensure all pending coroutines complete
     * before asserting the final state.
     */
    @Test
    fun `initial state eventually becomes Success`() = runTest {
        // Advance the virtual clock until all coroutines are finished
        dispatcher.scheduler.advanceUntilIdle()

        // Assert that the final state is Success, meaning data was loaded correctly
        assertTrue(viewModel.uiState.value is CarListUiState.Success)
    }
}