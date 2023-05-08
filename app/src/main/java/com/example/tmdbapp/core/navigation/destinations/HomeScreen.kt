package com.example.tmdbapp.core.navigation.destinations

import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.tmdbapp.core.navigation.Routes
import com.example.tmdbapp.core.navigation.Routes.DETAILS_SCREEN
import com.example.tmdbapp.core.navigation.Routes.SEARCH_SCREEN
import com.example.tmdbapp.presentation.SharedViewModel
import com.example.tmdbapp.presentation.home.HomeScreen

infix fun NavGraphBuilder.homeScreenComposable(
    navController: NavController
) {
    composable(route = Routes.HOME_SCREEN) { navBackStackEntry ->
        val parentEntry = remember(navBackStackEntry) {
            navController.getBackStackEntry(Routes.ROOT)
        }
        val sharedViewModel = hiltViewModel<SharedViewModel>(parentEntry)
        HomeScreen(
            viewModel = sharedViewModel,
            toSearchScreen = {
                navController.navigate(route = SEARCH_SCREEN)
            },
            getMovieDetails = {
                navController.navigate(route = DETAILS_SCREEN)
            }
        )
    }
}