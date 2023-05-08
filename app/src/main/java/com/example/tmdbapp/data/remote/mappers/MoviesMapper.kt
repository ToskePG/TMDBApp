package com.example.tmdbapp.data.remote.mappers

import com.example.tmdbapp.core.utils.idToGenre
import com.example.tmdbapp.data.remote.dto.MoviesDto
import com.example.tmdbapp.domain.model.Movie
import kotlin.random.Random

fun MoviesDto.toMovies() : List<Movie> {
    val moviesDtoList = this.results
    val result = arrayListOf<Movie>()
    moviesDtoList?.forEach { movieDto ->
        if (movieDto.genres?.isEmpty() == false && movieDto.poster != null && movieDto.backdrop != null) {
            result.add(
                Movie(
                    poster = movieDto.poster,
                    id = movieDto.id ?: -1,
                    genre = movieDto.genres[0].idToGenre(),
                    date = movieDto.date ?: Random.nextInt(2000,2023).toString(),
                    overview = movieDto.overview ?: "",
                    title = movieDto.title ?: "",
                    runtime = movieDto.runtime ?: Random.nextInt(100, 180),
                    votes = movieDto.votes ?: -1f,
                    backdrop = movieDto.backdrop
                )
            )
        }
    }
    return result.toList()
}