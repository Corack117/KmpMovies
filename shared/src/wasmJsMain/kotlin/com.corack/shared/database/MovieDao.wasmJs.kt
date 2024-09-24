package com.corack.shared.database

import com.corack.shared.models.Movie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

actual interface MoviesDao {
    actual fun fetchPopularMovies(): Flow<List<Movie>>
    actual fun fetchMovieById(id: Int): Flow<Movie?>
    actual suspend fun save(movies: List<Movie>)
}

class MoviesDaoJVM : MoviesDao {
    private val _movies = MutableStateFlow<List<Movie>>(emptyList())

    override fun fetchPopularMovies(): Flow<List<Movie>> {
        return _movies
    }

    override fun fetchMovieById(id: Int): Flow<Movie?> {
        return _movies.map { movieList ->
            movieList.find { it.id == id }
        }
    }

    override suspend fun save(movies: List<Movie>) {
        _movies.value += movies
    }
}
