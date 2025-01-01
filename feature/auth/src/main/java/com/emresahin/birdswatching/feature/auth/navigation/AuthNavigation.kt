package com.emresahin.birdswatching.feature.auth.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.emresahin.birdswatching.feature.auth.LoginScreen
import com.emresahin.birdswatching.feature.auth.RegisterScreen

const val AUTH_GRAPH_ROUTE = "auth_graph"

fun NavController.navigateToAuth(navOptions: NavOptions? = null) {
    navigate(AUTH_GRAPH_ROUTE, navOptions)
}

fun NavGraphBuilder.authGraph(
    navController: NavController,
    onAuthSuccess: () -> Unit,
    nestedGraphs: NavGraphBuilder.() -> Unit = {}
) {
    navigation(
        route = AUTH_GRAPH_ROUTE,
        startDestination = AuthRoute.LOGIN
    ) {
        composable(route = AuthRoute.LOGIN) {
            LoginScreen(
                onNavigateToRegister = {
                    navController.navigate(AuthRoute.REGISTER)
                },
                onLoginSuccess = onAuthSuccess
            )
        }

        composable(route = AuthRoute.REGISTER) {
            RegisterScreen(
                onNavigateToLogin = {
                    navController.popBackStack()
                },
                onRegisterSuccess = onAuthSuccess
            )
        }

        nestedGraphs()
    }
} 