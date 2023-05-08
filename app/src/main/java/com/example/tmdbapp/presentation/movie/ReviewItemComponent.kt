package com.example.tmdbapp.presentation.movie

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.tmdbapp.R
import com.example.tmdbapp.domain.model.Review

@Composable
fun ReviewItemComponent(
    review: Review
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            println("avatar is: " + review.avatarPath)
            AsyncImage(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(44.dp),
                model = if(review.avatarPath.contains("https")){
                    review.avatarPath.drop(1)
                        }
                    else stringResource(id = R.string.poster_template,review.avatarPath),
                contentDescription =null ,
                contentScale = ContentScale.Crop
            )
            Text(
                text = review.rating.toString(),
                color = Blue,
                fontSize = 12.sp,
                textAlign = TextAlign.Center
            )
        }
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(
                text = review.author,
                color = White,
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                textAlign = TextAlign.Start
            )
            Text(
                text = review.content,
                color = White,
                fontSize = 12.sp,
                textAlign = TextAlign.Start
            )
        }
    }

}