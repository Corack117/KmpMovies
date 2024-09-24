package com.corack.shared.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import com.corack.shared.models.Movie

const val DATABASE_NAME = "movies.db"

@Database(entities = [Movie::class], version = 1, exportSchema = false)
@ConstructedBy(MoviesDatabaseConstructor::class)
actual abstract class MoviesDatabase : RoomDatabase() {
    actual abstract fun moviesDao(): MoviesDao
}