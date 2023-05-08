package com.example.tmdbapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class AuthorDetailsDto(
    val rating : Float ? = null,
    @SerializedName("avatar_path")
    val avatarPath : String ? = null
)
