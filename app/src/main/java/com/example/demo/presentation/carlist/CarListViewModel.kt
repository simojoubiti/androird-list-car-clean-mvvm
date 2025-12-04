package com.example.demo.presentation.carlist
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demo.domain.model.Car
import com.example.demo.domain.usecase.GetCarsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Sealed class representing the different states of the Car List screen.
 * This allows the UI to reactively display loading indicators, error messages,
 * or the list of cars in a type-safe manner.
 */
sealed class CarListUiState {
    /** Indicates that data is currently being fetched. */
    object Loading : CarListUiState()

    /** Indicates that the car data has been successfully loaded. */
    data class Success(val cars: List<Car>) : CarListUiState()

    /** Indicates that an error occurred while fetching data. */
    data class Error(val message: String) : CarListUiState()
}

/**
 * ViewModel for the [CarListScreen].
 *
 * This class is responsible for managing the UI state, fetching car data via the [getCarsUseCase],
 * and handling user interactions such as refreshing the list or selecting a car brand.
 * It is managed by Hilt and its lifecycle is tied to the navigation graph.
 *
 * @property getCarsUseCase The use case for retrieving car data.
 * @author JOUBITI MOHAMMED
 */
@HiltViewModel
class CarListViewModel @Inject constructor(
    private val getCarsUseCase: GetCarsUseCase
) : ViewModel() {

    /**
     * The primary UI state for the screen, exposed as a read-only [StateFlow].
     * The UI will observe this flow to recompose based on changes (Loading, Success, Error).
     */
    private val _uiState = MutableStateFlow<CarListUiState>(CarListUiState.Loading)
    val uiState: StateFlow<CarListUiState> = _uiState

    /**
     * A state flow to specifically manage the visibility of the swipe-to-refresh indicator.
     */
    private val _isRefreshing = MutableStateFlow(false)
    val isRefreshing: StateFlow<Boolean> = _isRefreshing

    /**
     * Holds the index of the currently selected car brand category.
     * The `private set` ensures it can only be modified within this ViewModel.
     */
    var selectedBrandIndex by mutableStateOf(0)
        private set

    /**
     * Updates the index of the selected brand category.
     *
     * @param index The new index to be set.
     */
    fun selectBrand(index: Int) {
        selectedBrandIndex = index
    }

    /**
     * Loads the list of cars for a given brand.
     *
     * It sets the state to [CarListUiState.Loading], launches a coroutine to fetch data,
     * and updates the UI state to [CarListUiState.Success] or [CarListUiState.Error] based on the result.
     *
     * @param _marke The car brand (make) to load.
     */
    fun loadCars(_marke: String) {
        viewModelScope.launch {
            _uiState.value = CarListUiState.Loading
            try {
                // Execute the use case to get the list of cars
                val cars = getCarsUseCase(make = _marke)
                _uiState.value = CarListUiState.Success(cars)
            } catch (e: Exception) {
                // In case of an error, update the state with an error message
                _uiState.value = CarListUiState.Error(
                    e.message ?: "Erreur lors du chargement des voitures"
                )
            }
        }
    }

    /**
     * Refreshes the car list for a given brand, typically triggered by a swipe-to-refresh action.
     *
     * This function sets the [_isRefreshing] state to true, re-fetches the data, and ensures
     * that the refreshing indicator is hidden once the operation is complete (either success or failure).
     *
     * @param _make The car brand (make) to refresh.
     */
    fun refresh(_make: String) {
        viewModelScope.launch {
            _isRefreshing.value = true
            try {
                val cars = getCarsUseCase(make = _make)
                _uiState.value = CarListUiState.Success(cars)
            } catch (e: Exception) {
                _uiState.value = CarListUiState.Error(
                    e.message ?: "Erreur lors de l’actualisation"
                )
            } finally {
                // Always set refreshing to false after the attempt
                _isRefreshing.value = false
            }
        }
    }

}