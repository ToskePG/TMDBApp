package com.example.tmdbapp.data.remote.mappers

import com.example.tmdbapp.data.remote.dto.CreditsDto
import com.example.tmdbapp.domain.model.Cast

fun CreditsDto.toCast() : List<Cast>{
    val castList = this.cast
    val result = arrayListOf<Cast>()
    castList?.forEach { cast ->
        result.add(
            Cast(
                name = cast.name ?: "",
                picturePath = cast.picturePath ?: ""
            )
        )
    }
    return result.toList()
}