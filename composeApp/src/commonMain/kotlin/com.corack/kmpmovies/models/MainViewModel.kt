package com.corack.kmpmovies.models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.corack.shared.models.Movie
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel(
    private val moviesService: MovieService
): ViewModel() {
    var state by mutableStateOf(UiState())
        private set

    init {
        viewModelScope.launch {
            state = UiState(loading = true)
            moviesService.movies.collect {
                if (it.isNotEmpty()) {
                    state = UiState(loading = false, movies = it)
                }
            }
        }
    }

    data class UiState (
        val loading: Boolean = false,
        val movies: List<Movie> = emptyList()
    )
}