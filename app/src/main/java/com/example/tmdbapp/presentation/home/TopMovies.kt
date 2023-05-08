package com.example.tmdbapp.presentation.home

import androidx.compose.foundation.clickable
import com.example.tmdbapp.R
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.tmdbapp.domain.model.Movie

@Composable
fun TopMovies(
    topMovies: List<Movie>,
    toSingleMovieDetails : (movie: Movie) -> Unit
){
    LazyRow(modifier = Modifier
        .fillMaxSize()
        .padding(12.dp),
        horizontalArrangement = Arrangement.spacedBy(30.dp)
    ){
        items(topMovies){ item: Movie ->
            AsyncImage(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(16.dp))
                    .height(210.dp)
                    .width(140.dp)
                    .clickable {
                        toSingleMovieDetails(item)
                    },
                model = stringResource(id = R.string.poster_template, item.poster),
                contentDescription =null,
            contentScale = ContentScale.Crop)
        }
    }
}