package com.example.tmdbapp.presentation.watch

import androidx.compose.foundation.background
import com.example.tmdbapp.R
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tmdbapp.core.components.MoviesListComponent
import com.example.tmdbapp.presentation.SharedEvent
import com.example.tmdbapp.presentation.SharedViewModel
import com.example.tmdbapp.ui.theme.DarkBlue

@Composable
fun WatchListScreen(
    viewModel : SharedViewModel,
    onArrowClicked : () -> Unit,
    goToDetails : () -> Unit
) {
    val state = viewModel.state
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBlue)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, start = 24.dp, end = 24.dp)
                .weight(0.1f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(94.dp)
        ) {
            IconButton(
                onClick = { onArrowClicked() },
                content = {
                    Icon(
                        painter = painterResource(id = R.drawable.back_arrow_ic),
                        contentDescription = null,
                        tint = White
                    )
                }
            )
            Text(
                text = stringResource(id = R.string.watch_list),
                color = White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )

        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.9f)
        ){
            if(state.watchList.isEmpty()) WatchListEmptyComponent()
            else MoviesListComponent(movies = state.watchList){ movie ->
                viewModel.onEvent(SharedEvent.MovieClicked(movie))
                goToDetails()
            }
        }
    }
}