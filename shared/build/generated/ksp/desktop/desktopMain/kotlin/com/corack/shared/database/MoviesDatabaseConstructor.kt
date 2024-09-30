package com.corack.shared.database

import androidx.room.RoomDatabaseConstructor

public actual object MoviesDatabaseConstructor : RoomDatabaseConstructor<MoviesDatabase> {
  actual override fun initialize(): MoviesDatabase =
      com.corack.shared.database.MoviesDatabase_Impl()
}
