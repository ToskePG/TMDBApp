package com.example.tmdbapp.presentation.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.tmdbapp.core.components.MovieDetailsComponent
import com.example.tmdbapp.domain.model.Movie
import androidx.compose.ui.Modifier

@Composable
fun SearchListComponent(
    movies : List<Movie>
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 29.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ){
        items(movies){ movie ->
            MovieDetailsComponent(movie = movie )
        }
    }
}