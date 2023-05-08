package com.example.tmdbapp.presentation.movie

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tmdbapp.R
import com.example.tmdbapp.core.utils.toYear
import com.example.tmdbapp.domain.model.Movie
import com.example.tmdbapp.ui.theme.Gray

@Composable
fun AboutMovie(
    movie : Movie
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 64.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(24.dp)
    ){
        Row(
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ){
            Icon(
                painter = painterResource(id =  R.drawable.date_ic),
                contentDescription = null,
                tint = Color.Gray
            )
            Text(
                text = movie.date.toYear(),
                fontSize = 14.sp,
                color = Color.Gray
            )
        }
        Divider(
            color = Gray,
            modifier = Modifier
                .height(25.dp)
                .width(1.dp)
        )
        Row (
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ){
            Icon(
                painter = painterResource(id =  R.drawable.runtime_ic),
                contentDescription = null,
                tint = Gray
            )
            Text(
                text = stringResource(id = R.string.runtime_template,movie.runtime),
                fontSize = 12.sp,
                color = Gray
            )
        }
        Divider(
            color = Gray,
            modifier = Modifier
                .height(25.dp)
                .width(1.dp)
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ){
            Icon(
                painter = painterResource(id =  R.drawable.genre_ic),
                contentDescription = null,
                tint = Gray,
                modifier = Modifier.padding(top = 3.dp)
            )
            Text(
                text = movie.genre,
                fontSize = 12.sp,
                color = Gray
            )
        }
    }
}