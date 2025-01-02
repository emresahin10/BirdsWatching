package com.emresahin.birdswatching.feature.home.navigation

import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.emresahin.birdswatching.feature.home.HomeScreen
import com.emresahin.birdswatching.feature.home.HomeViewModel

const val homeNavigationRoute = "home_route"

fun NavController.navigateToHome(navOptions: NavOptions? = null) {
    this.navigate(homeNavigationRoute, navOptions)
}

fun NavGraphBuilder.homeScreen(
    onBirdClick: (String) -> Unit
) {
    composable(route = homeNavigationRoute) {
        val viewModel = hiltViewModel<HomeViewModel>()
        HomeScreen(
            viewModel = viewModel,
            onBirdClick = onBirdClick
        )
    }
} 