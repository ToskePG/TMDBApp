package com.example.tmdbapp.presentation.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.tmdbapp.data.Movie
import com.example.tmdbapp.ui.theme.TMDBAppTheme

@Composable
fun TopMovies(
    topMovies: List<Movie>
){
    println(topMovies)
}

@Preview
@Composable
fun TopMoviesPreview(){
    TMDBAppTheme {
        TopMovies(topMovies = emptyList())
    }
}