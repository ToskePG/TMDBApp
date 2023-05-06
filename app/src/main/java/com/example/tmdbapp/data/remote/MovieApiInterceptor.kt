package com.example.tmdbapp.data.remote

import com.example.tmdbapp.core.utils.addTMDBKeys
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieApiInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().addTMDBKeys()
        return chain.proceed(request)
    }
}