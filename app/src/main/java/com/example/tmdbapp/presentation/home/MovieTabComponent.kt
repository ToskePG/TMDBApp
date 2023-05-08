package com.example.tmdbapp.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.unit.dp
import androidx.compose.material.Tab
import androidx.compose.material.Text
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.tmdbapp.R
import com.example.tmdbapp.core.utils.Constants
import com.example.tmdbapp.core.utils.toName
import com.example.tmdbapp.domain.model.Movie

@Composable
fun MovieTabComponent(
    selectedTabIndex: Int,
    onSelectedTab: (Int, Constants.Tabs) -> Unit,
    movies: List<Movie>,
    toSingleMovieDetails : (movie:Movie) -> Unit
){
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        TabRow(selectedTabIndex = selectedTabIndex,
            indicator = {tabPositions ->
                Box(
                    modifier = Modifier
                        .tabIndicatorOffset(tabPositions[selectedTabIndex])
                        .height(4.dp)
                        .padding(horizontal = 28.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(color = LightGray)
                )
            }
        ) {
            Constants.Tabs.values().forEachIndexed { index, tabs ->
                Tab(
                    modifier = Modifier
                        .background(Gray),
                    selected = index == selectedTabIndex,
                    onClick = {onSelectedTab(index,tabs)},
                    text = {Text(text = tabs.name.toName(), maxLines = 1, fontSize = 14.sp)}
                )
            }
        }
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            verticalArrangement = Arrangement.spacedBy(18.dp)
        ) {
            items(movies) {item: Movie ->
                AsyncImage(
                    modifier = Modifier
                        .height(146.dp)
                        .width(100.dp),
                    model = stringResource(id = R.string.poster_template, item.poster),
                    contentDescription = null
                )
            }
        }
    }
}