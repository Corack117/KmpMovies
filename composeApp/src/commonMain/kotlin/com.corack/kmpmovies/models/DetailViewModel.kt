package com.corack.kmpmovies.models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.corack.shared.models.Movie
import kotlinx.coroutines.launch

class DetailViewModel(
    private val id: Int,
    private val movieService: MovieService
) : ViewModel() {
    var state by mutableStateOf(UiState())
        private set

    init {
        viewModelScope.launch {
            state = UiState(loading = true)
            movieService.fetchMovieById(id).collect {
                it.let {
                    state = UiState(loading = false, movie = it)
                }
            }
        }
    }

    data class UiState(
        val loading: Boolean = false,
        val movie: Movie? = null
    )

    fun onFavoriteClick() {
        state.movie?.let {
            viewModelScope.launch {
                movieService.toggleFavorite(it)
            }
        }
    }
}