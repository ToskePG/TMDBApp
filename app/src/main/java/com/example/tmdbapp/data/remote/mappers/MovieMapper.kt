package com.example.tmdbapp.data.remote.mappers

import com.example.tmdbapp.core.utils.idToGenre
import com.example.tmdbapp.data.remote.dto.MoviesDto
import com.example.tmdbapp.domain.model.Movie
import kotlin.random.Random

fun MoviesDto.toMovies() : List<Movie>{
    val moviesDtoList = this.results
    val result = arrayListOf<Movie>()
    moviesDtoList?.forEach{ movieDto ->
        val genre = movieDto.genres?.get(0)?.idToGenre()
        result.add(
            Movie(
                poster = movieDto.moviePoster ?: "",
                id = movieDto.id ?: -1,
                genre = genre ?: "",
                date = movieDto.date ?: "",
                overview = movieDto.overview ?: "",
                title = movieDto.title ?: "",
                runtime = movieDto.runtime ?: Random.nextInt(100,180),
                votes = movieDto.averageVote ?: -1f
            )
        )
    }

    return result.toList()
}