package com.example.tmdbapp.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tmdbapp.core.utils.NetworkResponse
import com.example.tmdbapp.core.utils.PreferenceCache
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
    private val movieRepo: MovieRepository,
    private val prefsCache: PreferenceCache
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

            is SharedEvent.MovieClicked ->{
                state = state.copy(detailMovie = event.movie)
                getCast(id = event.movie.id)
                getReviews(id = event.movie.id)
                isBookmarked(id = event.movie.id)
            }
            is SharedEvent.MovieBookmark ->{
                checkBookmarks(event.movie)
            }
        }
    }

    private fun checkBookmarks(movie: Movie) {
        prefsCache.watchList.forEachIndexed {  index ,bookmark->
            if(bookmark.id == movie.id){
                val list = prefsCache.watchList
                list.removeAt(index)
                prefsCache.watchList = list
                state = state.copy(isBookmarked = false ,watchList = prefsCache.watchList)
                return
            }
        }
        val list = prefsCache.watchList
        list.add(movie)
        prefsCache.watchList = list
        state = state.copy(isBookmarked = true, watchList = prefsCache.watchList)
    }

    private fun isBookmarked(id: Int) {
        prefsCache.watchList.forEach { movie->
            if(movie.id == id){
                state = state.copy(isBookmarked = true)
                return
            }
        }
        state = state.copy(isBookmarked = false)
    }

    init {
        getNowPlaying()
        getUpcoming()
        getPopular()
        getTopRated()
        state = state.copy(watchList = prefsCache.watchList)
    }

    private fun getNowPlaying(){
        viewModelScope.launch {
            movieRepo.getNowPlayingMovies().collectLatest { networkResponse ->
                val moviesList = networkResponse.data
                when(networkResponse){
                    is NetworkResponse.Success ->{
                        if(moviesList != null){
                            state = state.copy(nowPlaying = moviesList)
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
            movieRepo.getUpcomingMovies().collectLatest { networkResponse ->
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
            movieRepo.getPopularMovies().collectLatest { networkResponse ->
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
            movieRepo.getTopRatedMovies().collectLatest { networkResponse ->
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
            movieRepo.getSearch(query = query).collectLatest { networkResponse ->
                val moviesList = networkResponse.data
                when(networkResponse){
                    is NetworkResponse.Success -> {
                        if (moviesList != null) {
                            state = state.copy(searchList = moviesList)
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

    private fun getReviews(id : Int){
        viewModelScope.launch {
            movieRepo.getReviews(id = id).collectLatest { networkResponse ->
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
            movieRepo.getCast(id = id).collectLatest { networkResponse ->
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
    val isError: Boolean = false,
    val nowPlaying : List<Movie> = listOf(),
    val upcoming : List<Movie> = listOf(),
    val popular : List<Movie> = listOf(),
    val topRated : List<Movie> = listOf(),
    val query: String = String(),
    val searchList : List<Movie> = listOf(),
    val watchList : MutableList<Movie> = mutableListOf(),
    val detailMovie : Movie? = null,
    val isBookmarked : Boolean = false,
    val reviews : List<Review> = listOf(),
    val cast : List<Cast> = listOf()
)
sealed class SharedEvent {
    data class QueryChanged(val query: String) : SharedEvent()
    object SearchMovies : SharedEvent()
    data class MovieClicked(val movie : Movie) : SharedEvent()
    data class MovieBookmark(val movie : Movie) : SharedEvent()
}