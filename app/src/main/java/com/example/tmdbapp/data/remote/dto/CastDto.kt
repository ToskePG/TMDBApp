package com.example.tmdbapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class CastDto(
    val name : String ? = null,
    @SerializedName("profile_path")
    val picturePath : String ? = null
)
