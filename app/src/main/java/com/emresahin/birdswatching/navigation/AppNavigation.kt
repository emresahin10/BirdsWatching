package com.emresahin.birdswatching.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.emresahin.birdswatching.feature.home.navigation.homeNavigationRoute
import com.emresahin.birdswatching.feature.home.navigation.homeScreen

@Composable
fun AppNavigation(
    navController: NavHostController,
    startDestination: String = homeNavigationRoute
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        homeScreen(
            onBirdClick = { birdId ->
                // TODO: Navigate to detail screen
            }
        )
    }
}