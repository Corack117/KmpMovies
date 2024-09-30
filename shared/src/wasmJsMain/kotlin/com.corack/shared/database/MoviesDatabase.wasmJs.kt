package com.corack.shared.database

actual abstract class MoviesDatabase {
    actual abstract fun moviesDao(): MoviesDao
}

class MoviesDatabaseJVM : MoviesDatabase() {
    override fun moviesDao(): MoviesDao {
        return MoviesDaoJVM()
    }
}