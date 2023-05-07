package com.example.tmdbapp.core.utils

import okhttp3.Request

fun Request.addTMDBKeys(): Request {
    val builder = this.newBuilder()
    return builder.build()
}

fun String.toYear() : String{
    return this.split('-')[0]
}

fun Int.idToGenre() : String {
    if(this == 12) return "Adventure"
    if(this == 14) return "Fantasy"
    if(this == 16) return "Animation"
    if(this == 18) return "Drama"
    if(this == 27) return "Horror"
    if(this == 28) return "Action"
    if(this == 35) return "Comedy"
    if(this == 36) return "History"
    if(this == 37) return "Western"
    if(this == 53) return "Thriller"
    if(this == 80) return "Crime"
    if(this == 99) return "Documentary"
    if(this == 878) return "Science Fiction"
    if(this == 9648) return "Mystery"
    if(this == 10402) return "Music"
    if(this == 10749) return "Romance"
    if(this == 10752) return "War"
    if(this == 10770) return "TV Movie"
    if(this == 19751) return "Family"
    return ""
}

fun String.toTabName() : String{
    var tab : String = this[0].toString()
    for (i in  1 until this.length){
        if(this[i] == '_'){
            tab+=" "
        }
        else{
            tab+= this[i].lowercase()
        }
    }
    return tab
}