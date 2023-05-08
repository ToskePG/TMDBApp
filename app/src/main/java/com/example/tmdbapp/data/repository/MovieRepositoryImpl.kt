package com.example.tmdbapp.data.repository

import com.example.tmdbapp.core.utils.NetworkResponse
import com.example.tmdbapp.data.remote.mappers.toCast
import com.example.tmdbapp.data.remote.mappers.toMovies
import com.example.tmdbapp.data.remote.mappers.toReviews
import com.example.tmdbapp.data.remote.services.MovieApi
import com.example.tmdbapp.domain.model.Cast
import com.example.tmdbapp.domain.model.Movie
import com.example.tmdbapp.domain.model.Review
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

    override suspend fun getReviews(id: Int): Flow<NetworkResponse<List<Review>>> {
        return flow{
            emit(NetworkResponse.Loading())
            try {
                val response = api.getReviews(id)
                val reviewsDto = response.body()
                if(response.isSuccessful && response.body() != null){
                    val reviews = reviewsDto?.toReviews()
                    emit(NetworkResponse.Success(data = reviews))
                }else {
                    emit(NetworkResponse.Error(message = "An error occurred during communication with server. "))
                }
            } catch (e: IOException) {
                emit(NetworkResponse.Error(message = "Request failed for the following reason: ${e.message}"))
            } catch (e: HttpException) {
                emit(NetworkResponse.Error(message = "Request failed for the following reason: ${e.message}"))
            }
        }
    }

    override suspend fun getCast(id: Int): Flow<NetworkResponse<List<Cast>>> {
        return flow{
            emit(NetworkResponse.Loading())
            try {
                val response = api.getCast(id)
                val creditsDto = response.body()
                if(response.isSuccessful && response.body() != null){
                    val cast = creditsDto?.toCast()
                    emit(NetworkResponse.Success(data = cast))
                }else {
                    emit(NetworkResponse.Error(message = "An error occurred during communication with server. "))
                }
            } catch (e: IOException) {
                emit(NetworkResponse.Error(message = "Request failed for the following reason: ${e.message}"))
            } catch (e: HttpException) {
                emit(NetworkResponse.Error(message = "Request failed for the following reason: ${e.message}"))
            }
        }
    }
}