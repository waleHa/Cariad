package com.waleed.cariad.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.waleed.cariad.ui.model.Movie
import com.waleed.cariad.ui.repositry.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor (private val movieRepository: MovieRepository): ViewModel() {
    private val _movies = MutableStateFlow<List<Movie>> (emptyList())
    val movies: StateFlow<List<Movie>> = _movies

    init {
        fetchMovies()
    }
    private fun fetchMovies(){
        viewModelScope.launch {
            movieRepository.getMovies().collect { movieList ->
            _movies.value = movieList

            }
        }
    }
}