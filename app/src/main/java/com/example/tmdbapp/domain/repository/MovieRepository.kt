package com.example.tmdbapp.domain.repository

interface MovieRepository {
    suspend fun getMovies()
}