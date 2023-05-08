package com.example.tmdbapp.presentation.movie

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.tmdbapp.domain.model.Review

@Composable
fun ReviewsComponent(
    reviews : List<Review>
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        items(reviews){ review ->
            ReviewItemComponent(review = review)
        }
    }
}