package com.example.tmdbapp.domain.model

import androidx.annotation.DrawableRes

data class Movie (
    val poster : String,
    val id : Int,
    val title : String,
    val votes : Float,
    val genre : String,
    val date : String,
    val runtime : Int,
    val overview : String,
    val backdrop : String
)
