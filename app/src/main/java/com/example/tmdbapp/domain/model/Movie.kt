package com.example.tmdbapp.domain.model

import androidx.annotation.DrawableRes

data class Movie(
    val movieTitle: String,
    @DrawableRes
    val moviePoster: Int,
    val movieRating: Int
)
