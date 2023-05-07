package com.example.tmdbapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.tmdbapp.core.components.BottomNavBar
import com.example.tmdbapp.core.navigation.graphs.AppNav
import com.example.tmdbapp.presentation.SharedViewModel
import com.example.tmdbapp.ui.theme.TMDBAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: SharedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TMDBAppTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = {
                        AnimatedVisibility(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(70.dp),
                            visible = viewModel.state.shouldShowBottomNavBar,
                            enter = fadeIn(),
                            exit = fadeOut()
                        ) {
                            BottomNavBar(
                                navController = navController,
                                onItemClick = { navItem ->
                                    navController.navigate(navItem.route) {
                                        popUpTo(route = navItem.route) {
                                            inclusive = true
                                        }
                                    }
                                }
                            )
                        }
                    }
                ) { innerPadding ->
                    println("Inner padding is $innerPadding")
                    AppNav(navController = navController)
                }
            }
        }
    }
}