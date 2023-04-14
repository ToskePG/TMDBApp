package com.example.tmdbapp.data.remote

import retrofit2.http.GET

interface MovieApi {

    @GET
    suspend fun getMovies()
}