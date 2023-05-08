package com.example.tmdbapp.core.navigation.destinations

import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.tmdbapp.core.navigation.Routes
import com.example.tmdbapp.core.navigation.Routes.SEARCH_SCREEN
import com.example.tmdbapp.presentation.SharedViewModel
import com.example.tmdbapp.presentation.search.SearchScreen

infix fun NavGraphBuilder.searchScreenComposable(
    navController: NavController
){
    composable(route = SEARCH_SCREEN) { navBackStackEntry ->
        val parentEntry = remember(navBackStackEntry) {
            navController.getBackStackEntry(Routes.ROOT)
        }
        val sharedViewModel = hiltViewModel<SharedViewModel>(parentEntry)
        SearchScreen(
            viewModel = sharedViewModel,
            onArrowClicked = {navController.popBackStack()},
            toMovieDetails = {
                navController.navigate(route = Routes.DETAILS_SCREEN)
            }
        )
    }
}