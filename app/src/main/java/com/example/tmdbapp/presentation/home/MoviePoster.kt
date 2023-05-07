package com.example.tmdbapp.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.tmdbapp.R

@Composable
fun MoviePoster(
    movie_Poster: String
){
    Box (modifier = Modifier
        .padding(all = 12.dp)
    ){
        AsyncImage(
            model = stringResource(
                id = R.string.poster_template),
            contentDescription = null)
    }
}