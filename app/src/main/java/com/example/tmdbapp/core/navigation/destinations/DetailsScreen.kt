package com.example.tmdbapp.core.navigation.destinations

import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.tmdbapp.presentation.SharedViewModel
import com.example.tmdbapp.core.navigation.Routes
import com.example.tmdbapp.presentation.movie.SingleMovieScreen

infix fun NavGraphBuilder.detailsScreenComposable(
    navController: NavController
) {
    composable(route = Routes.DETAILS_SCREEN) { navBackStackEntry ->
        val parentEntry = remember(navBackStackEntry) {
            navController.getBackStackEntry(Routes.ROOT)
        }
        val sharedViewModel = hiltViewModel<SharedViewModel>(parentEntry)
        SingleMovieScreen(
            viewModel = sharedViewModel,
            onArrowClicked = { navController.popBackStack() }
        )
    }
}