package com.example.tmdbapp.core.components

import androidx.compose.foundation.background
import com.example.tmdbapp.R
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.tmdbapp.core.utils.toYear
import com.example.tmdbapp.domain.model.Movie
import com.example.tmdbapp.ui.theme.Gray
import com.example.tmdbapp.ui.theme.Orange
import com.example.tmdbapp.ui.theme.TMDBAppTheme


@Composable
fun MovieDetailsComponent(
    movie : Movie
){
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 32.dp)
            .background(Gray)
    ) {
        Column(
            modifier = Modifier
                .width(120.dp)
                .height(90.dp)
                .clip(RoundedCornerShape(16.dp))
        ) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxSize(),
                model = stringResource(
                    id = R.string.poster_template,
                    movie.poster),
                contentDescription = null)
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 15.dp)
    ) {
        Row{
            Text(
                text = movie.title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontSize = 16.sp,
                color = White
            )
        }
        Row(
            modifier = Modifier
                .padding(top = 15.dp),
            horizontalArrangement = Arrangement.spacedBy(5.5.dp)
        ){
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ){
                Row(
                    horizontalArrangement = Arrangement.spacedBy(5.5.dp)
                ) {
                    Icon(
                        painter = painterResource(id =  R.drawable.rates_ic),
                        contentDescription = null,
                        tint = Orange
                    )
                    Text(
                        text = movie.votes.toString(),
                        fontSize = 12.sp,
                        color = Orange,
                        fontWeight = FontWeight.Bold
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.spacedBy(5.5.dp)
                ) {
                    Icon(
                        painter = painterResource(id =  R.drawable.genre_ic),
                        contentDescription = null,
                        tint = White,
                        modifier = Modifier.padding(top = 3.dp)
                    )
                    Text(
                        text = movie.genre,
                        fontSize = 12.sp,
                        color = White
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.spacedBy(5.5.dp)
                ) {
                    Icon(
                        painter = painterResource(id =  R.drawable.date_ic),
                        contentDescription = null,
                        tint = White
                    )
                    Text(
                        text = movie.date.toYear(),
                        fontSize = 12.sp,
                        color = White
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.spacedBy(5.5.dp)
                ) {
                    Icon(
                        painter = painterResource(id =  R.drawable.runtime_ic),
                        contentDescription = null,
                        tint = White
                    )
                    Text(
                        text = stringResource(id = R.string.runtime_template,movie.runtime),
                        fontSize = 12.sp,
                        color = White
                    )
                }
            }
        }
    }
}


@Preview(showBackground = false)
@Composable
fun MovieDetailsComponentPreview() {
    TMDBAppTheme{
        MovieDetailsComponent(
            Movie(
                votes = 7.2f,
                title = "Spider-Man",
                runtime = 139,
                overview = "OVERWIEW OF THE MOVIE",
                date = "2023-22-09",
                poster = stringResource(id = R.string.poster_template,"/pB8BM7pdSp6B6Ih7QZ4DrQ3PmJK.jpg"),
                genre = "Action",
                id = 13
            )
        )
    }

}