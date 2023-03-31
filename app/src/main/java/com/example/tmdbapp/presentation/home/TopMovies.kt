package com.example.tmdbapp.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tmdbapp.core.utils.Constants.getMovies
import com.example.tmdbapp.domain.model.Movie
import com.example.tmdbapp.presentation.splash.MoviePoster
import com.example.tmdbapp.ui.theme.TMDBAppTheme

@Composable
fun TopMovies(
    topMovies: List<Movie>
){
    LazyRow(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 24.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ){
        items(topMovies){ item ->  
            MoviePoster(movie_Poster = item.moviePoster)
        }
    }
}

@Preview
@Composable
fun TopMoviesPreview(){
    TMDBAppTheme {
        TopMovies(topMovies = getMovies())
    }
}