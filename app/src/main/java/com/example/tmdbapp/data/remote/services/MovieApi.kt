package com.example.tmdbapp.data.remote.services

import retrofit2.http.GET

interface MovieApi {
    @GET
    suspend fun getMovies()
}