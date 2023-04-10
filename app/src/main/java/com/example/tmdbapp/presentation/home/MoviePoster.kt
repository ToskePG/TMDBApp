package com.example.tmdbapp.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.tmdbapp.ui.theme.TMDBAppTheme

@Composable
fun MoviePoster(
    // Before API calls, later change to URL
    movie_Poster: Int
){
    Image(
        painter = painterResource(id = movie_Poster),
        contentDescription = null)
}

@Preview
@Composable
fun MoviePosterPreview(){
    TMDBAppTheme {
        //MoviePoster(movie_Poster = R.drawable.spiderman)
    }
}