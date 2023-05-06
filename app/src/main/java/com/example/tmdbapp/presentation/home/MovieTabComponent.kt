package com.example.tmdbapp.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material.Tab
import androidx.compose.material.Text
import androidx.compose.ui.unit.sp
import com.example.tmdbapp.domain.model.Movie
import com.example.tmdbapp.ui.theme.TMDBAppTheme

@Composable
fun MovieTabComponent(
    selectedTabIndex: Int,
    onSelectedTab: (TabPage) -> Unit,
){
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
            TabPage.values().forEachIndexed { index, tabs ->
                Tab(
                    selected = index == selectedTabIndex,
                    onClick = {onSelectedTab(tabs)},
                    text = {Text(text = tabs.name, maxLines = 1, fontSize = 14.sp)}
                )
            }
    }
}
enum class TabPage{
    NOW_PLAYING,
    UPCOMING,
    TOP_RATED,
    POPULAR
}

@Preview
@Composable
fun MovieTabComponentPreview(){
    TMDBAppTheme {
        MovieTabComponent(selectedTabIndex = 1, onSelectedTab = {})
    }
}