package com.example.tmdbapp.presentation.movie

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.tmdbapp.R
import com.example.tmdbapp.domain.model.Cast

@Composable
fun CastComponent(
    cast : List<Cast>
) {

    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxWidth(),
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(25.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ){
        items(cast){ actor ->
            Column(
                verticalArrangement = Arrangement.spacedBy(15.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AsyncImage(
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(100.dp),
                    model = stringResource(id = R.string.poster_template,actor.picturePath),
                    contentDescription =null,
                    contentScale = ContentScale.Crop
                )

                Text(
                    text = actor.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    color = White
                    )
            }
        }
    }
}