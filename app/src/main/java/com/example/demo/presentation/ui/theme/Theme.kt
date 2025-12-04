package com.example.demo.presentation.ui.theme
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

/**
 * Defines the light color scheme for the application.
 *
 * This palette is used when the app is in light mode. It specifies key colors like
 * the background and surface colors to create a consistent look and feel.
 */
private val LightColors = lightColorScheme(
    background = Color(0xFFF7F7F7),
    surface = Color.White
)

/**
 * Defines the dark color scheme for the application.
 *
 * This palette is used when the app is in dark mode. Currently, it uses the default
 * Material 3 dark color values.
 */
private val DarkColors = darkColorScheme()

/**
 * The main theme for the Car List application.
 *
 * This Composable function wraps the entire UI of the app, providing a consistent
 * set of colors, typography, and shapes based on Material Design 3. It automatically
 * detects whether the system is in dark mode and applies the appropriate color scheme.
 *
 * @param useDarkTheme A boolean indicating whether to use the dark theme. Defaults to the system setting.
 * @param content The composable content that will inherit this theme.
 * @author JOUBITI MOHAMMED
 */
@Composable
fun AppListCarTheme(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    // Select the appropriate color scheme based on the useDarkTheme flag.
    val colors = if (useDarkTheme) DarkColors else LightColors

    // Apply the MaterialTheme to the content of the app.
    MaterialTheme(
        colorScheme = colors,
        // Using default Material3 typography for now. This can be customized.
        typography = Typography(),
        content = content
    )
}

