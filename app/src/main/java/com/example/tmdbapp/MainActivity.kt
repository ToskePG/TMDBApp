package com.example.tmdbapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.tmdbapp.domain.repository.MovieRepository
import com.example.tmdbapp.presentation.SharedViewModel
import com.example.tmdbapp.presentation.home.HomeScreen
import com.example.tmdbapp.ui.theme.DarkBlue
import com.example.tmdbapp.ui.theme.TMDBAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TMDBAppTheme {
                val navController = rememberNavController()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = DarkBlue
                ) {

                }
            }
        }
    }
}