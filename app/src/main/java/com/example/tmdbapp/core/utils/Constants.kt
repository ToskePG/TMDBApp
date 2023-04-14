package com.example.tmdbapp.core.utils

import com.example.tmdbapp.R
import com.example.tmdbapp.domain.model.Movie

object Constants {
    fun getMovies() : List<Movie>{
        return listOf(
            Movie(moviePoster = R.drawable.satoru_poster, movieTitle = "Satoru", movieRating = 5),
            Movie(moviePoster = R.drawable.wood_poster, movieTitle = "Wood", movieRating = 5),
            Movie(moviePoster = R.drawable.joker_poster, movieTitle = "Joker", movieRating = 5),
            Movie(moviePoster = R.drawable.satoru_poster, movieTitle = "Satoru", movieRating = 5),
            Movie(moviePoster = R.drawable.wood_poster, movieTitle = "Wood", movieRating = 5),
            Movie(moviePoster = R.drawable.joker_poster, movieTitle = "Joker", movieRating = 5)
        )
    }
    val BASE_URL = "https://api.themoviedb.org/3/movie/"
}