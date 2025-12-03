package com.example.demo.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.demo.presentation.carlist.CarListScreen
import com.google.gson.Gson

object Routes {
    const val CAR_LIST = "car_list"
}

@Composable
fun RentACarNavHost() {
    val navController = rememberNavController()
    val gson = remember { Gson() }

    NavHost(
        navController = navController,
        startDestination = Routes.CAR_LIST
    ) {
        composable(Routes.CAR_LIST) {
            CarListScreen(
                onCarClick = { car ->
                    val carJson = gson.toJson(car)
                }
            )
        }

    }
}
