package com.example.tmdbapp.data

import androidx.annotation.DrawableRes

data class Movie(
    val movieTitle: String,
    @DrawableRes
    val moviePoster: Int,
    val movieRating: Int
)
