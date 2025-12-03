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

sealed class CarListUiState {
    object Loading : CarListUiState()
    data class Success(val cars: List<Car>) : CarListUiState()
    data class Error(val message: String) : CarListUiState()
}

@HiltViewModel
class CarListViewModel @Inject constructor(
    private val getCarsUseCase: GetCarsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<CarListUiState>(CarListUiState.Loading)
    val uiState: StateFlow<CarListUiState> = _uiState

    private val _isRefreshing = MutableStateFlow(false)
    val isRefreshing: StateFlow<Boolean> = _isRefreshing

    var selectedBrandIndex by mutableStateOf(0)
        private set
    fun selectBrand(index: Int) {
        selectedBrandIndex = index
    }
    fun loadCars(_marke: String) {
        viewModelScope.launch {
            _uiState.value = CarListUiState.Loading
            try {
                val cars = getCarsUseCase(make = _marke)
                _uiState.value = CarListUiState.Success(cars)
            } catch (e: Exception) {
                _uiState.value = CarListUiState.Error(
                    e.message ?: "Erreur lors du chargement des voitures"
                )
            }
        }
    }

    fun refresh(_make :String) {
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
                _isRefreshing.value = false
            }
        }
    }

}
