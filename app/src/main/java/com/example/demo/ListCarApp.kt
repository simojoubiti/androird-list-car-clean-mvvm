package com.example.demo
import android.app.Application
import dagger.hilt.android.HiltAndroidApp
/**
 * The main Application class for the project.
 *
 * This class serves as the entry point for the app and triggers Dagger Hilt's code generation.
 * The `@HiltAndroidApp` annotation is crucial here; it creates a base class for the application
 * that acts as the application-level dependency container. All other Hilt components in the app
 * (like Activities, Fragments, ViewModels) rely on this being present.
 *
 * @author JOUBITI MOHAMMED
 */
@HiltAndroidApp
class ListCarApp : Application()