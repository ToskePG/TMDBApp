package com.example.tmdbapp.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.example.tmdbapp.core.utils.Constants
import com.example.tmdbapp.presentation.SharedViewModel

@Composable
fun HomeScreen(
    viewModel : SharedViewModel
){
    Column {
        SearchBar(
            value = "",
            placeholder = "Search for the movie",
            isError = false,
            onSearch = { /*TODO*/ },
            onTextChanged = {}
        )
        TopMovies(topMovies = Constants.getMovies())
        TopMovies(topMovies = Constants.getMovies())
    }
}