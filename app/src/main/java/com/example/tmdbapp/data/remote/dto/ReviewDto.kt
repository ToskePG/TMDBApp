package com.example.tmdbapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class ReviewDto(
    val author : String? = null,
    @SerializedName("author_details")
    val details : AuthorDetailsDto? = null,
    val content : String? = null
)
