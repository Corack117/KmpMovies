package com.corack.shared.database

actual abstract class MoviesDatabase {
    actual abstract fun moviesDao(): MoviesDao
}
