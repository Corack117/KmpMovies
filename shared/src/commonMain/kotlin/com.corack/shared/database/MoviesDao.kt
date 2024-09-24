package com.corack.shared.database

import com.corack.shared.models.Movie
import kotlinx.coroutines.flow.Flow

expect interface MoviesDao {
    fun fetchPopularMovies(): Flow<List<Movie>>
    fun fetchMovieById(id: Int): Flow<Movie?>
    suspend fun save(movies: List<Movie>)
}