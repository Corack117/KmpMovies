package com.corack.shared.database

fun getDatabaseBuilder(): MoviesDatabase {
    return MoviesDatabaseJVM()
}