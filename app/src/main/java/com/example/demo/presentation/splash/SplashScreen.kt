package com.example.demo.presentation.splash
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.demo.R
/**
 * A Composable function that displays the application's splash screen.
 *
 * This screen is typically shown when the app first launches. It features a Lottie
 * animation loop (`car_splash_`) centered on the screen to provide visual feedback
 * while the app initializes or performs startup tasks.
 *
 * @author JOUBITI MOHAMMED
 */
@Composable
fun SplashScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        // Load the Lottie composition from the raw resource file
        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.car_splash_))

        // Create an animation state that iterates forever
        val progress by animateLottieCompositionAsState(
            composition = composition,
            iterations = LottieConstants.IterateForever
        )
        // Render the Lottie animation
        LottieAnimation(
            composition = composition,
            progress = { progress },
            modifier = Modifier.fillMaxSize()
        )
    }
}

