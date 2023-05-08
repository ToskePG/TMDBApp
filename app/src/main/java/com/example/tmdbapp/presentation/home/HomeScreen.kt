package com.example.tmdbapp.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tmdbapp.presentation.SharedViewModel
import com.example.tmdbapp.ui.theme.DarkBlue
import androidx.compose.material.Text
import com.example.tmdbapp.R
import com.example.tmdbapp.core.components.SearchBar
import com.example.tmdbapp.presentation.SharedEvent

@Composable
fun HomeScreen(
    viewModel : SharedViewModel,
    toSearchScreen: () -> Unit,
    toMovieDetails : () -> Unit
){
    val state = viewModel.state
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBlue)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp)
                .weight(0.1f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ){
            Text(
                text = stringResource(id = R.string.watch),
                fontSize = 18.sp,
                color = White
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.1f)
                .padding(horizontal = 24.dp)
        ) {
            SearchBar(
                value = state.query,
                placeholder = stringResource(id = R.string.search),
                isError = state.isError,
                onTextChanged = { query ->
                    viewModel.onEvent(SharedEvent.QueryChanged(query = query))
                }
            ){
                viewModel.onEvent(SharedEvent.SearchMovies)
                toSearchScreen()
            }
        }
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.4f)
                .padding(horizontal = 24.dp)
        ){
            TopMovies(topMovies = state.popular){ movie ->
                viewModel.onEvent(SharedEvent.MovieClicked(movie))
                toMovieDetails()
            }
        }
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.4f)
        ) {
            MovieTabComponent(
                selectedTabIndex = state.tabPage,
                onSelectedTab = { index,tabs ->
                    viewModel.onEvent(SharedEvent.TabClicked(index = index,tabs))
                },
                movies = state.tabMovies){ movie ->
                viewModel.onEvent(SharedEvent.MovieClicked(movie))
                toMovieDetails()
            }
        }
    }
}