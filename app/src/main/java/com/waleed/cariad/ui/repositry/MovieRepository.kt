package com.waleed.cariad.ui.repositry

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.waleed.cariad.ui.model.Movie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MovieRepository {
    // mock response
    private val jsonString = """
    [
        { "title": "Inception", "rating": 8.8, "year": 2010 },
        { "title": "The Dark Knight", "rating": 9.0, "year": 2008 },
        { "title": "Interstellar", "rating": 8.6, "year": 2014 },
        { "title": "Dunkirk", "rating": 7.9, "year": 2017 },
        { "title": "Memento", "rating": 8.4, "year": 2000 },
        { "title": "The Prestige", "rating": 8.5, "year": 2006 },
        { "title": "Batman Begins", "rating": 8.2, "year": 2005 },
        { "title": "Avatar", "rating": 7.5, "year": 2009 },
        { "title": "Up", "rating": 8.3, "year": 2009 },
        { "title": "The Matrix", "rating": 8.7, "year": 1999 },
        { "title": "Toy Story 3", "rating": 8.3, "year": 2010 }
    ]
    """
        // use gson for parsing
    private val gson= Gson()

    // fetch movies

    fun getMovies(): Flow<List<Movie>> = flow {
        val movieListType= object: TypeToken<List<Movie>>() {}.type
        val movies : List<Movie> = gson.fromJson(jsonString, movieListType)
        emit(movies)
    }
}