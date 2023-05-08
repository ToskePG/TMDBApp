package com.example.tmdbapp.core.navigation.graphs

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.navigation
import com.example.tmdbapp.core.navigation.Routes.HOME_SCREEN
import com.example.tmdbapp.core.navigation.Routes.ROOT
import com.example.tmdbapp.core.navigation.destinations.*

infix fun NavGraphBuilder.rootNavGraph(
    navController: NavController
){
    navigation(
        route = ROOT,
        startDestination = HOME_SCREEN
    ){
        this homeScreenComposable navController
        this searchScreenComposable navController
        this watchListScreenComposable navController
        this detailsScreenComposable navController
        this splashScreenComposable navController
    }
}
