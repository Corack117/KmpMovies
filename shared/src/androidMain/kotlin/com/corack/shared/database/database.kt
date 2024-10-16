package com.corack.shared.database

import android.content.Context
import androidx.room.Room

fun getDatabaseBuilder(ctx: Context): MoviesDatabase {
    val appContext = ctx.applicationContext
    val dbFile = appContext.getDatabasePath(DATABASE_NAME)
    return Room.databaseBuilder<MoviesDatabase>(
        context = appContext,
        name = dbFile.absolutePath
    ).build()
}