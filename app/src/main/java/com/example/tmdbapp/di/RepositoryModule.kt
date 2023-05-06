package com.example.tmdbapp.di

import com.example.tmdbapp.data.repository.MovieRepositoryImpl
import com.example.tmdbapp.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {
    @Binds
    @ViewModelScoped
    abstract fun bindMovieRepository(
        movieRepositoryImpl: MovieRepositoryImpl
    ) : MovieRepository
}