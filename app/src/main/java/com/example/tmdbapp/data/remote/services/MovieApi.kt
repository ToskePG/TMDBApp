package com.example.tmdbapp.data.remote.services

import com.example.tmdbapp.domain.model.Movie
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
    @GET("movies")
    suspend fun getMovies(
        @Query("movie_id") query: String
    ) : Response<Movie>
}