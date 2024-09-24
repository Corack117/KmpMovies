package com.corack.shared.database

import com.corack.shared.models.Movie

expect abstract class MoviesDatabase {
    abstract fun moviesDao(): MoviesDao
}