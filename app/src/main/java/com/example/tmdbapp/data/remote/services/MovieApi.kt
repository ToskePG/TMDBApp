package com.example.tmdbapp.data.remote.services

import com.example.tmdbapp.BuildConfig.API_KEY
import com.example.tmdbapp.data.remote.dto.CreditsDto
import com.example.tmdbapp.data.remote.dto.MoviesDto
import com.example.tmdbapp.data.remote.dto.ReviewsDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {
    @GET("movie/now_playing")
    suspend fun getNowPlayingMovies(
        @Query("api_key") apiKey: String = API_KEY,
    ) : Response<MoviesDto>

    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(
        @Query("api_key") apiKey: String = API_KEY
    ) : Response<MoviesDto>

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query("api_key") apiKey: String = API_KEY
    ) : Response<MoviesDto>

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String = API_KEY
    ) : Response<MoviesDto>

    @GET("search/movie")
    suspend fun searchMovies(
        @Query("api_key") apiKey : String = API_KEY,
        @Query("query") query : String
    ) : Response<MoviesDto>

    @GET("movie/{id}/reviews")
    suspend fun getReviews(
        @Path("id") id: Int,
        @Query("api_key") apiKey: String = API_KEY
    ) : Response<ReviewsDto>

    @GET("movie/{id}/credits")
    suspend fun getCast(
        @Path("id") id: Int,
        @Query("api_key") apiKey: String = API_KEY
    ) : Response<CreditsDto>
}