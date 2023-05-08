package com.example.tmdbapp.presentation.movie

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tmdbapp.core.utils.Constants
import com.example.tmdbapp.core.utils.toName
import com.example.tmdbapp.domain.model.Cast
import com.example.tmdbapp.domain.model.Movie
import com.example.tmdbapp.domain.model.Review
import com.example.tmdbapp.ui.theme.DarkBlue
import com.example.tmdbapp.ui.theme.Gray
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabsComponent(
    movie: Movie,
    reviews: List<Review>,
    cast: List<Cast>
){
    val pagerState : PagerState = rememberPagerState(initialPage = 0)
    val scope = rememberCoroutineScope()
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        TabRow(
            selectedTabIndex = pagerState.currentPage,
            indicator = { tabPositions ->
                Box(
                    modifier = Modifier
                        .tabIndicatorOffset(tabPositions[pagerState.currentPage])
                        .height(4.dp)
                        .padding(horizontal = 28.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(color = DarkBlue)
                )
            }
        ) {
            Constants.PagerTabs.values().forEachIndexed { index, tabs ->
                Tab(
                    modifier = Modifier
                        .background(Gray),
                    selected = index == pagerState.currentPage,
                    onClick = {
                        scope.launch {
                            pagerState.scrollToPage(index)
                        }
                    },
                    text = {
                        Text(
                            text = tabs.name.toName(),
                            maxLines = 1,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                )
            }
        }
        HorizontalPager(
            pageCount = Constants.PagerTabs.values().size,
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp, top = 20.dp)
                .fillMaxSize(),
            state = pagerState
        ) { page ->
            when(page){
                0 ->{
                    Text(
                        modifier = Modifier.
                        fillMaxSize(),
                        text = movie.overview,
                        fontSize = 12.sp,
                        color = White
                    )
                }
                1-> {
                    ReviewsComponent(reviews)
                }
                2->{
                    CastComponent(cast)
                }
            }
        }
    }
}