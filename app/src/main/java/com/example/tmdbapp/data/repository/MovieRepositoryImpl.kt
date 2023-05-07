package com.example.tmdbapp.data.repository

import com.example.tmdbapp.core.utils.NetworkResponse
import com.example.tmdbapp.data.remote.services.MovieApi
import com.example.tmdbapp.domain.model.Movie
import com.example.tmdbapp.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

class MovieRepositoryImpl(
    private val api: MovieApi
) : MovieRepository {
    override suspend fun getPopularMovies(): Flow<NetworkResponse<List<Movie>>> {
        TODO("Not yet implemented")
    }

    override suspend fun getNowPlayingMovies(): Flow<NetworkResponse<List<Movie>>> {
        TODO("Not yet implemented")
    }

    override suspend fun getUpcomingMovies(): Flow<NetworkResponse<List<Movie>>> {
        TODO("Not yet implemented")
    }

    override suspend fun getTopRatedMovies(): Flow<NetworkResponse<List<Movie>>> {
        TODO("Not yet implemented")
    }

    override suspend fun getSearch(query: String): Flow<NetworkResponse<List<Movie>>> {
        TODO("Not yet implemented")
    }

}