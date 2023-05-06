package com.example.tmdbapp.core.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.tmdbapp.core.navigation.Routes.ROOT

@Composable
fun AppNav(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = ROOT
    ) {
        this rootNavGraph navController
    }
}