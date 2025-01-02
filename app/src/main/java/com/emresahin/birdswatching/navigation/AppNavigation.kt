package com.emresahin.birdswatching.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.emresahin.birdswatching.feature.auth.navigation.AUTH_GRAPH_ROUTE
import com.emresahin.birdswatching.feature.auth.navigation.authGraph
import com.emresahin.birdswatching.feature.home.navigation.HOME_ROUTE
import com.emresahin.birdswatching.feature.home.navigation.homeScreen
import com.emresahin.birdswatching.feature.home.navigation.navigateToHome

@Composable
fun AppNavigation(
    isAuthenticated: Boolean,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = if (isAuthenticated) HOME_ROUTE else AUTH_GRAPH_ROUTE
    ) {
        authGraph(
            navController = navController,
            onAuthSuccess = { userId ->
                navController.navigateToHome(
                    userId = userId,
                    navOptions = navOptions {
                        popUpTo(navController.graph.id) {
                            inclusive = true
                        }
                    }
                )
            }
        )

        homeScreen(
            onBackClick = {
                navController.popBackStack()
            }
        )
    }
}