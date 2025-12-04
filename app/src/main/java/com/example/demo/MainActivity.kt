package com.example.demo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.demo.presentation.navigation.RentACarNavHost
import com.example.demo.presentation.splash.SplashScreen
import com.example.demo.presentation.ui.theme.AppListCarTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
/**
 * The main entry point for the Android application.
 *
 * This Activity hosts the Jetpack Compose UI content. It is annotated with [AndroidEntryPoint]
 * to allow Hilt to inject dependencies into the Android components hosted within it.
 *
 * The Activity handles the initial navigation logic, specifically displaying the [SplashScreen]
 * for a fixed duration before transitioning to the main content defined in [RentACarNavHost].
 *
 * @author JOUBITI MOHAMMED
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    /**
     * Called when the activity is starting.
     *
     * This is where most initialization should go: calling [setContentView] (via [setContent] for Compose)
     * to inflate the UI.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down,
     *                           this Bundle contains the data it most recently supplied in onSaveInstanceState.
     *                           Otherwise, it is null.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppListCarTheme {
                // State to control the visibility of the splash screen
                var showSplash by remember { mutableStateOf(true) }

                // Effect to handle the splash screen timer
                LaunchedEffect(Unit) {
                    // Wait for 4.5 seconds
                    delay(4500)
                    // Hide splash screen and show main content
                    showSplash = false
                }

                // Conditional rendering based on splash state
                if (showSplash) {
                    SplashScreen()
                } else {
                    RentACarNavHost()
                }
            }
        }
    }
}