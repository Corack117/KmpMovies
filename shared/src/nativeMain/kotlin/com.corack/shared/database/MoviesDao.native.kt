package com.corack.shared.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.corack.shared.models.Movie
import kotlinx.coroutines.flow.Flow

@Dao
actual interface MoviesDao {
    @Query("SELECT * FROM Movie")
    actual fun fetchPopularMovies(): Flow<List<Movie>>

    @Query("SELECT * FROM Movie WHERE id = :id")
    actual fun fetchMovieById(id: Int): Flow<Movie?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    actual suspend fun save(movies: List<Movie>)
}