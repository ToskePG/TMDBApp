package com.example.tmdbapp.data.repository

import com.example.tmdbapp.core.utils.NetworkResponse
import com.example.tmdbapp.data.remote.mappers.toMovies
import com.example.tmdbapp.data.remote.services.MovieApi
import com.example.tmdbapp.domain.model.Movie
import com.example.tmdbapp.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val api: MovieApi
) : MovieRepository {
    override suspend fun getPopularMovies(): Flow<NetworkResponse<List<Movie>>> {
       return flow {
           emit(NetworkResponse.Loading())
           try {
               val response = api.getPopularMovies()
               val moviesDto = response.body()
               if (response.isSuccessful && response.body() != null) {
                   val movies = moviesDto?.toMovies()
                   emit(NetworkResponse.Success(data = movies))
               } else {
                   emit(NetworkResponse.Error(message = "An error occurred."))
               }
           }catch (e: IOException) {
               emit(NetworkResponse.Error(message = "Request failed"))
           } catch (e: HttpException) {
               emit(NetworkResponse.Error(message = "Request failed"))
           }
       }
    }

    override suspend fun getNowPlayingMovies(): Flow<NetworkResponse<List<Movie>>> {
        return flow {
            emit(NetworkResponse.Loading())
            try {
                val response = api.getNowPlayingMovies()
                val moviesDto = response.body()
                if (response.isSuccessful && response.body() != null) {
                    val movies = moviesDto?.toMovies()
                    emit(NetworkResponse.Success(data = movies))
                } else {
                    emit(NetworkResponse.Error(message = "An error occurred."))
                }
            }catch (e: IOException) {
                emit(NetworkResponse.Error(message = "Request failed"))
            } catch (e: HttpException) {
                emit(NetworkResponse.Error(message = "Request failed"))
            }
        }
    }

    override suspend fun getUpcomingMovies(): Flow<NetworkResponse<List<Movie>>> {
        return flow {
            emit(NetworkResponse.Loading())
            try {
                val response = api.getUpcomingMovies()
                val moviesDto = response.body()
                if (response.isSuccessful && response.body() != null) {
                    val movies = moviesDto?.toMovies()
                    emit(NetworkResponse.Success(data = movies))
                } else {
                    emit(NetworkResponse.Error(message = "An error occurred."))
                }
            }catch (e: IOException) {
                emit(NetworkResponse.Error(message = "Request failed"))
            } catch (e: HttpException) {
                emit(NetworkResponse.Error(message = "Request failed"))
            }
        }
    }

    override suspend fun getTopRatedMovies(): Flow<NetworkResponse<List<Movie>>> {
        return flow {
            emit(NetworkResponse.Loading())
            try {
                val response = api.getTopRatedMovies()
                val moviesDto = response.body()
                if (response.isSuccessful && response.body() != null) {
                    val movies = moviesDto?.toMovies()
                    emit(NetworkResponse.Success(data = movies))
                } else {
                    emit(NetworkResponse.Error(message = "An error occurred."))
                }
            }catch (e: IOException) {
                emit(NetworkResponse.Error(message = "Request failed"))
            } catch (e: HttpException) {
                emit(NetworkResponse.Error(message = "Request failed"))
            }
        }
    }

    override suspend fun getSearch(query: String): Flow<NetworkResponse<List<Movie>>> {
        return flow {
            emit(NetworkResponse.Loading())
            try {
                val response = api.searchMovies(query = query)
                val moviesDto = response.body()
                if (response.isSuccessful && response.body() != null) {
                    val movies = moviesDto?.toMovies()
                    emit(NetworkResponse.Success(data = movies))
                } else {
                    emit(NetworkResponse.Error(message = "An error occurred."))
                }
            }catch (e: IOException) {
                emit(NetworkResponse.Error(message = "Request failed"))
            } catch (e: HttpException) {
                emit(NetworkResponse.Error(message = "Request failed"))
            }
        }
    }
}