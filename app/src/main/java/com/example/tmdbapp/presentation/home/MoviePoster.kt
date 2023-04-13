package com.example.tmdbapp.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun MoviePoster(
    // Before API calls, later change to URL
    movie_Poster: Int
){
    Box (modifier = Modifier
        .padding(all = 12.dp)
    ){
        Image(
            painter = painterResource(id = movie_Poster),
            contentDescription = null)
    }
}