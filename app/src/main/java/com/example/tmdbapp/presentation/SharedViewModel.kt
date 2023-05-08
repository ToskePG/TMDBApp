package com.example.tmdbapp.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tmdbapp.core.utils.Constants
import com.example.tmdbapp.core.utils.NetworkResponse
import com.example.tmdbapp.domain.model.Cast
import com.example.tmdbapp.domain.model.Movie
import com.example.tmdbapp.domain.model.Review
import com.example.tmdbapp.domain.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(
    private val repository: MovieRepository
) : ViewModel() {
    var state by mutableStateOf(SharedState())
    fun onEvent(event: SharedEvent) {
        when (event) {
            is SharedEvent.QueryChanged -> {
                state = state.copy(query = event.query)
            }
            is SharedEvent.SearchMovies -> {
                state = state.copy(searchList = listOf())
                searchMovies(query = state.query)
            }
            is SharedEvent.TabClicked -> {
                state = state.copy(tabPage = event.index)
                changeTab(tab = event.tab)
            }
            is SharedEvent.MovieClicked -> {
                state = state.copy(detailMovie = event.movie)
                getCast(id = event.movie.id)
                getReviews(id = event.movie.id)
                //isBookmarked(id = event.movie.id)
            }
            is SharedEvent.MovieBookmark -> {
                // checkBookmarks(event.movie)
            }
        }
    }

    init {
        getNowPlaying()
        getUpcoming()
        getPopular()
        getTopRated()
    }

    private fun getNowPlaying(){
        viewModelScope.launch {
            repository.getNowPlayingMovies().collectLatest { networkResponse ->
                val moviesList = networkResponse.data
                when(networkResponse){
                    is NetworkResponse.Success ->{
                        if(moviesList != null){
                            state = state.copy(nowPlaying = moviesList, tabMovies = moviesList)
                        }
                    }
                    is NetworkResponse.Error -> {
                        state = state.copy( isError = true )
                    }
                    is NetworkResponse.Loading -> Unit
                }
            }
        }
    }

    private fun getUpcoming(){
        viewModelScope.launch {
            repository.getUpcomingMovies().collectLatest { networkResponse ->
                val moviesList = networkResponse.data
                when(networkResponse){
                    is NetworkResponse.Success ->{
                        if(moviesList != null){
                            state = state.copy(upcoming = moviesList)
                        }
                    }
                    is NetworkResponse.Error -> {
                        state = state.copy( isError = true )
                    }
                    is NetworkResponse.Loading -> Unit
                }
            }
        }
    }

    private fun getPopular(){
        viewModelScope.launch {
            repository.getPopularMovies().collectLatest { networkResponse ->
                val moviesList = networkResponse.data
                when(networkResponse){
                    is NetworkResponse.Success ->{
                        if(moviesList != null){
                            state = state.copy(popular = moviesList)
                        }
                    }
                    is NetworkResponse.Error -> {
                        state = state.copy( isError = true )
                    }
                    is NetworkResponse.Loading -> Unit
                }
            }
        }
    }

    private fun getTopRated(){
        viewModelScope.launch {
            repository.getTopRatedMovies().collectLatest { networkResponse ->
                val moviesList = networkResponse.data
                when(networkResponse){
                    is NetworkResponse.Success ->{
                        if(moviesList != null){
                            state = state.copy(topRated = moviesList)
                        }
                    }
                    is NetworkResponse.Error -> {
                        state = state.copy( isError = true )
                    }
                    is NetworkResponse.Loading -> Unit
                }
            }
        }
    }

    private fun searchMovies(query : String){
        viewModelScope.launch {
            repository.getSearch(query = query).collectLatest { networkResponse ->
                val movies = networkResponse.data
                when(networkResponse){
                    is NetworkResponse.Success ->{
                        if (movies != null) {
                            state = state.copy(searchList = movies)
                        }
                    }
                    is NetworkResponse.Error -> {
                        state = state.copy( isError = true )
                    }
                    is NetworkResponse.Loading -> Unit
                }
            }
        }
    }

    private fun changeTab(tab : Constants.Tabs){
        state = when(tab){
            Constants.Tabs.NOW_PLAYING -> {
                state.copy(tabMovies = state.nowPlaying)
            }
            Constants.Tabs.UPCOMING -> {
                state.copy(tabMovies = state.upcoming)
            }
            Constants.Tabs.TOP_RATED -> {
                state.copy(tabMovies = state.topRated)
            }
            Constants.Tabs.POPULAR -> {
                state.copy(tabMovies = state.popular)
            }
        }
    }

    private fun getReviews(id : Int){
        viewModelScope.launch {
            repository.getReviews(id = id).collectLatest { networkResponse ->
                val reviews = networkResponse.data
                when(networkResponse){
                    is NetworkResponse.Success -> {
                        if (reviews != null) {
                            state = state.copy(reviews = reviews)
                        }
                    }
                    is NetworkResponse.Error -> {
                        state = state.copy( isError = true )
                    }
                    is NetworkResponse.Loading -> Unit
                }
            }
        }
    }
    private fun getCast(id : Int){
        viewModelScope.launch {
            repository.getCast(id = id).collectLatest { networkResponse ->
                val cast = networkResponse.data
                when(networkResponse){
                    is NetworkResponse.Success -> {
                        if (cast != null) {
                            state = state.copy(cast = cast)
                        }
                    }
                    is NetworkResponse.Error -> {
                        state = state.copy( isError = true )
                    }
                    is NetworkResponse.Loading -> Unit
                }
            }
        }
    }
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
    val shouldShowBottomNavBar : Boolean = true,
    val watchList : MutableList<Movie> = mutableListOf(),
    val isBookmarked : Boolean = false,
    val detailMovie : Movie? = null,
    val reviews : List<Review> = listOf(),
    val cast : List<Cast> = listOf()
)
sealed class SharedEvent {
    data class QueryChanged(val query: String) : SharedEvent()
    object SearchMovies : SharedEvent()
    data class TabClicked(val index : Int, val tab : Constants.Tabs) : SharedEvent()
    data class MovieClicked(val movie : Movie) : SharedEvent()
    data class MovieBookmark(val movie : Movie) : SharedEvent()
}