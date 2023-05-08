package com.example.tmdbapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class MovieDto(
    val id: Int? = null,
    val title: String? = null,
    @SerializedName("poster_path")
    val moviePoster: String? = null,
    @SerializedName("vote_average")
    val averageVote: Float? = null,
    val genres: List<Int>? = null,
    @SerializedName("release_date")
    val date: String? = null,
    val runtime: Int? = null,
    val overview: String? = null,
    @SerializedName("backdrop_path")
    val backdrop : String? = null
)
