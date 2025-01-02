package com.emresahin.birdswatching.feature.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.emresahin.birdswatching.feature.home.HomeScreen

const val HOME_ROUTE = "home_graph"
private const val HOME_SCREEN_ROUTE = "home_screen"

fun NavController.navigateToHome(userId: String, navOptions: NavOptions? = null) {
    navigate("$HOME_SCREEN_ROUTE/$userId", navOptions)
}

fun NavGraphBuilder.homeScreen(
    onBackClick: () -> Unit
) {
    navigation(
        route = HOME_ROUTE,
        startDestination = "$HOME_SCREEN_ROUTE/{userId}"
    ) {
        composable(
            route = "$HOME_SCREEN_ROUTE/{userId}",
        ) { backStackEntry ->
            val userId = backStackEntry.arguments?.getString("userId") ?: ""
            HomeScreen(userId = userId)
        }
    }
} 