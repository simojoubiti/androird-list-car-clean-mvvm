package com.example.demo.presentation.navigation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.demo.presentation.carlist.CarListScreen
import com.google.gson.Gson
/**
 * Holds the constant route names used for navigation within the app.
 *
 * Using constants helps avoid typos and "magic strings" when navigating between screens.
 */
object Routes {
    /** Route for the screen displaying the list of cars. */
    const val CAR_LIST = "car_list"
}
/**
 * The main navigation host for the Rent-A-Car application.
 *
 * This composable sets up the [NavHost] and defines the navigation graph.
 * It acts as the entry point for the app's UI navigation logic, handling transitions
 * between different screens (currently primarily the Car List).
 *
 * @author JOUBITI MOHAMMED
 */
@Composable
fun RentACarNavHost() {
    // Create a NavController to manage app navigation
    val navController = rememberNavController()

    // Create a Gson instance to serialize objects if needed for navigation arguments
    val gson = remember { Gson() }

    NavHost(
        navController = navController,
        startDestination = Routes.CAR_LIST
    ) {
        // Define the destination for the Car List screen
        composable(Routes.CAR_LIST) {
            CarListScreen(
                onCarClick = { car ->
                    // Currently serializes the car object, potentially for future navigation to a details screen
                    val carJson = gson.toJson(car)
                    // TODO: Navigate to details screen passing carJson
                }
            )
        }

    }
}

