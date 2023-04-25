package com.example.tmdbapp.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.tmdbapp.R
import com.example.tmdbapp.ui.theme.DarkBlue

@Composable
fun EmptyStateScreen(){
    Box(
    modifier = Modifier
        .fillMaxSize()
        .background(DarkBlue),
        contentAlignment = Alignment.Center
    ){
        Column {
            Image(painter = painterResource(id = R.drawable.empty_screen_icon),
                contentDescription = null)
            Text("There were no movies found :(")
        }

    }
}