package com.example.tmdbapp.data.repository

import com.example.tmdbapp.data.remote.MovieApi
import com.example.tmdbapp.domain.repository.MovieRepository

class MovieRepositoryImpl(
    private val api: MovieApi
) : MovieRepository {
    override suspend fun getMovies() {
        TODO("Not yet implemented")
    }
}