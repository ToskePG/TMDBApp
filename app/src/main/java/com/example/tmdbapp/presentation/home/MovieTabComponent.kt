package com.example.tmdbapp.presentation.home

import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.tmdbapp.domain.model.Movie

@Composable
fun MovieTab(
    selectedTabIndex: Int,
    onSelectedTab: (TabPage) -> Unit
){
    TabRow(selectedTabIndex = selectedTabIndex) {
        TabPage.values().forEachIndexed{ index, tabPage ->
            Tab(
                selected = index == selectedTabIndex,
                onClick = {onSelectedTab(tabPage)},
                text = {Text(text = tabPage.name)}
                )
        }
    }
}

enum class TabPage(val icon: ImageVector){
    NOW_PLAYING(Icons.Default.Home),
    POPULAR(Icons.Default.Favorite),
    UPCOMING(Icons.Default.Add)
}