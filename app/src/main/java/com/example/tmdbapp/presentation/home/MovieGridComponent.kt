package com.example.tmdbapp.presentation.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.tmdbapp.R
import com.example.tmdbapp.domain.model.Movie

@Composable
fun MovieGridComponent(
    movies : List<Movie>,
    goToDetails : (movie : Movie) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        verticalArrangement = Arrangement.spacedBy(18.dp),
        horizontalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        items(movies) { movie: Movie ->
            AsyncImage(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .height(146.dp)
                    .width(100.dp).clickable {
                        goToDetails(movie)
                    },
                model = stringResource(id = R.string.poster_template, movie.poster),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
    }
}