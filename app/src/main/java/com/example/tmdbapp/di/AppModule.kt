package com.example.tmdbapp.di

import com.example.tmdbapp.core.utils.Constants
import com.example.tmdbapp.data.remote.MovieApi
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    fun provideMovieApi() : MovieApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .build()
            .create(MovieApi::class.java)
    }
}