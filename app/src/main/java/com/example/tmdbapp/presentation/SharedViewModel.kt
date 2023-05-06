package com.example.tmdbapp.presentation

import androidx.lifecycle.ViewModel
import com.example.tmdbapp.domain.repository.MovieRepository
import javax.inject.Inject

class SharedViewModel @Inject constructor(
    private val repository: MovieRepository
) : ViewModel() {

}