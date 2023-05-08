package com.example.tmdbapp.core.utils

import android.content.Context
import androidx.preference.PreferenceManager
import com.example.tmdbapp.domain.model.Movie
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PreferenceCache @Inject constructor(@ApplicationContext val context: Context) {
    private val prefs = PreferenceManager.getDefaultSharedPreferences(context)
    private val gson = Gson()
    private val sType = object : TypeToken<MutableList<Movie>>() { }.type

    var watchList : MutableList<Movie>
        get() = gson.fromJson(prefs.getString(WATCH_LIST,"") , sType) ?: mutableListOf()

        set(value) = with(prefs.edit()) {
            val jsonString = gson.toJson(value)
            putString(WATCH_LIST,jsonString)
            apply()
        }

    companion object {
        private var WATCH_LIST = String()
    }
}