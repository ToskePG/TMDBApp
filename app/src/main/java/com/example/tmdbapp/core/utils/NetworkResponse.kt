package com.example.tmdbapp.core.utils

sealed class NetworkResponse<T>(
    val data: T? = null,
    val message: String? = null
){
    class Success<T>(data: T? = null, message: String? = null) : NetworkResponse<T>(data,message)
    class Error<T>(message: String? = null) : NetworkResponse<T>(message = message)
    class Loading<T>(data: T? = null, message: String? = null) : NetworkResponse<T>(data = data, message = message)
}
