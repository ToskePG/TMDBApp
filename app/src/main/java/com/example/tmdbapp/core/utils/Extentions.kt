package com.example.tmdbapp.core.utils

import okhttp3.Request

fun Request.addTMDBKeys(): Request {
    val builder = this.newBuilder()
    return builder.build()
}