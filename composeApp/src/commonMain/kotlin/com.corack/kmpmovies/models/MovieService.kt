package com.corack.kmpmovies.models

import com.corack.shared.database.MoviesDao
import com.corack.shared.models.Movie
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach

class MovieService(
    private val moviesDao: MoviesDao,
    private val client: HttpClient
) {
    val movies: Flow<List<Movie>> = moviesDao.fetchPopularMovies().onEach { movies ->
        if (movies.isEmpty()) {
            val popularMovies = fetchPopularMovies().results.map { it.toMovie() }
            moviesDao.save(popularMovies)
        }
    }

    suspend private fun fetchPopularMovies(): RemoteResult {
        return client
            .get("/3/discover/movie?sort_by=popularity.desc")
            .body<RemoteResult>()
    }

    suspend fun fetchMovieById(id: Int): Flow<Movie?> = moviesDao.fetchMovieById(id).onEach { movie ->
        movie.let {
            val result = client
                .get("/3/movie/$id")
                .body<RemoteMovie>()
            val remoteMovie = result.toMovie()
            moviesDao.save(listOf(remoteMovie))
        }
    }
}