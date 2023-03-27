package com.example.tmdbapp.presentation.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.tmdbapp.R
import com.example.tmdbapp.ui.theme.DarkBlue
import com.example.tmdbapp.ui.theme.TMDBAppTheme

@Composable
fun SplashScreen(){
    Splash()
}

@Composable
fun Splash(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBlue),
        contentAlignment = Alignment.Center
    ) {
        Image(painter = painterResource(id = R.drawable.popcorn),
            contentDescription = null)
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    TMDBAppTheme {
        SplashScreen()
    }
}

