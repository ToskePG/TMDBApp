package com.example.tmdbapp.presentation

import androidx.lifecycle.ViewModel
import com.example.tmdbapp.core.utils.Constants
import com.example.tmdbapp.domain.model.Movie
import com.example.tmdbapp.domain.repository.MovieRepository
import javax.inject.Inject

class SharedViewModel @Inject constructor(
    private val repository: MovieRepository
) : ViewModel() {

}

data class SharedState(
    val shouldShowSearch: Boolean = false,
    val isError: Boolean = false,
    val nowPlaying : List<Movie> = listOf(),
    val upcoming : List<Movie> = listOf(),
    val popular : List<Movie> = listOf(),
    val topRated : List<Movie> = listOf(),
    val tabMovies : List<Movie> = listOf(),
    val tabPage : Int = 0,
    val query: String = String(),
    val searchList : List<Movie> = listOf(),
    val shouldShowBottomNavBar : Boolean = true
)
sealed class SharedEvent {
    data class QueryChanged(val query: String) : SharedEvent()
    object SearchMovies : SharedEvent()
    data class TabClicked(val index : Int, val tab : Constants.Tabs) : SharedEvent()
}