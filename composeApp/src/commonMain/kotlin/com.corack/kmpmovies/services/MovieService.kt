package com.corack.kmpmovies.services

import com.corack.shared.database.MoviesDao
import com.corack.shared.models.Movie
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach

class MovieService(
    private val moviesDao: MoviesDao,
    private val client: HttpClient,
    private val regionRepository: RegionRepository
) {
    val movies: Flow<List<Movie>> = moviesDao.fetchPopularMovies().onEach { movies ->
        if (movies.isEmpty()) {
            val popularMovies = fetchPopularMovies(
                regionRepository.fetchRegion()
            )
            val moviesFetched = popularMovies?.let { remoteResult ->
                remoteResult.results.map { it.toMovie() }
            }
            moviesDao.save(moviesFetched ?: emptyList())
        }
    }

    suspend private fun fetchPopularMovies(region: String): RemoteResult? {
        return try {
            client
                .get("/3/discover/movie") {
                    parameter("region", region)
                    parameter("sort_by", "popularity.desc")
                }
                .body<RemoteResult>()
        } catch (e: Exception) { null }
    }

    suspend fun fetchMovieById(id: Int): Flow<Movie?> = moviesDao.fetchMovieById(id).onEach { movie ->
        if (movie == null) {
            try {
                val result = client
                    .get("/3/movie/$id")
                    .body<RemoteMovie>()
                val remoteMovie = result.toMovie()
                moviesDao.save(listOf(remoteMovie))
            } catch (e: Exception) {
                moviesDao.save(listOf())
            }
        }
    }

    suspend fun toggleFavorite(movie: Movie) {
        moviesDao.save(
            listOf(movie.update(isFavorite = !movie.isFavorite))
        )
    }
}