package com.example.tmdbapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.tmdbapp.core.components.BottomNavBar
import com.example.tmdbapp.core.navigation.Routes
import com.example.tmdbapp.core.navigation.graphs.AppNav
import com.example.tmdbapp.ui.theme.TMDBAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TMDBAppTheme {
                val navController = rememberNavController()
                val bottomBarState = rememberSaveable{ mutableStateOf(true)}
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                bottomBarState.value = when(navBackStackEntry?.destination?.route){
                    Routes.DETAILS_SCREEN -> false
                    Routes.SPLASH_SCREEN -> false
                    else -> true
                }
                Scaffold(
                    bottomBar = {
                        AnimatedVisibility(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(70.dp),
                            visible = bottomBarState.value,
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