package com.example.tmdbapp.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.example.tmdbapp.core.utils.Constants

@Composable
fun HomeScreen(){
    Column {
        TopMovies(topMovies = Constants.getMovies())
        TopMovies(topMovies = Constants.getMovies())
    }
    
}