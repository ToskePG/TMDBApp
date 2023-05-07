package com.example.tmdbapp.di

import com.example.tmdbapp.BuildConfig
import com.example.tmdbapp.core.utils.Constants
import com.example.tmdbapp.data.remote.services.MovieApi
import com.example.tmdbapp.data.remote.MovieApiInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideOkHttpClient(movieApiInterceptor: MovieApiInterceptor) : OkHttpClient{
        val loggerInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        return OkHttpClient.Builder()
            .addInterceptor(loggerInterceptor)
            .addInterceptor(movieApiInterceptor)
            .build()
    }

    fun provideMovieApi() : MovieApi {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .build()
            .create(MovieApi::class.java)
    }
}