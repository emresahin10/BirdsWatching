package com.emresahin.birdswatching.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.emresahin.birdswatching.feature.auth.LoginScreen
import com.emresahin.birdswatching.feature.auth.RegisterScreen

@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = AppDestination.Login.route
    ) {
        composable(AppDestination.Login.route) {
            LoginScreen(
                onNavigateToRegister = {
                    navController.navigate(AppDestination.Register.route)
                },
                onLoginSuccess = {
                    // TODO: Navigate to home screen
                }
            )
        }

        composable(AppDestination.Register.route) {
            RegisterScreen(
                onNavigateToLogin = {
                    navController.popBackStack()
                },
                onRegisterSuccess = {
                    // TODO: Navigate to home screen
                }
            )
        }
    }
}

sealed class AppDestination(val route: String) {
    data object Login : AppDestination("login")
    data object Register : AppDestination("register")
    data object Home : AppDestination("home")
} 