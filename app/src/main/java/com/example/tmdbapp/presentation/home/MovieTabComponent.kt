package com.example.tmdbapp.presentation.home

import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.tmdbapp.ui.theme.TMDBAppTheme

@Composable
fun MovieTabComponent(
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
enum class TabPage{
    NOW_PLAYING,
    POPULAR,
    UPCOMING
}

@Preview
@Composable
fun MovieTabComponentPreview(){
    TMDBAppTheme {
        MovieTabComponent(selectedTabIndex = 1, onSelectedTab = {})
    }
}