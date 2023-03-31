package com.example.tmdbapp.core.utils

import com.example.tmdbapp.R
import com.example.tmdbapp.domain.model.Movie

object Constants {
    fun getMovies() : List<Movie>{
        return listOf(
            Movie(moviePoster = R.drawable.spiderman, movieTitle = "Spiderman", movieRating = 5),
            Movie(moviePoster = R.drawable.spider_man, movieTitle = "Spiderman", movieRating = 5),
            Movie(moviePoster = R.drawable.spiderman, movieTitle = "Spiderman", movieRating = 5),
            Movie(moviePoster = R.drawable.spider_man, movieTitle = "Spiderman", movieRating = 5),
            Movie(moviePoster = R.drawable.spiderman, movieTitle = "Spiderman", movieRating = 5),
            Movie(moviePoster = R.drawable.spider_man, movieTitle = "Spiderman", movieRating = 5)
        )
    }
}