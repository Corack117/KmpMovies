package com.corack.shared.database

import androidx.room.InvalidationTracker
import androidx.room.RoomOpenDelegate
import androidx.room.migration.AutoMigrationSpec
import androidx.room.migration.Migration
import androidx.room.util.TableInfo
import androidx.room.util.TableInfo.Companion.read
import androidx.room.util.dropFtsSyncTriggers
import androidx.sqlite.SQLiteConnection
import androidx.sqlite.execSQL
import javax.`annotation`.processing.Generated
import kotlin.Lazy
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.MutableList
import kotlin.collections.MutableMap
import kotlin.collections.MutableSet
import kotlin.collections.Set
import kotlin.collections.mutableListOf
import kotlin.collections.mutableMapOf
import kotlin.collections.mutableSetOf
import kotlin.reflect.KClass

@Generated(value = ["androidx.room.RoomProcessor"])
@Suppress(names = ["UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION", "REMOVAL"])
public class MoviesDatabase_Impl : MoviesDatabase() {
  private val _moviesDao: Lazy<MoviesDao> = lazy {
    MoviesDao_Impl(this)
  }


  protected override fun createOpenDelegate(): RoomOpenDelegate {
    val _openDelegate: RoomOpenDelegate = object : RoomOpenDelegate(1,
        "caca85dc4dd8f1bf51030029c5ab6df2", "682a5aaf58882a80cff80c7d506e8597") {
      public override fun createAllTables(connection: SQLiteConnection) {
        connection.execSQL("CREATE TABLE IF NOT EXISTS `Movie` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `title` TEXT NOT NULL, `overview` TEXT NOT NULL, `releaseDate` TEXT NOT NULL, `poster` TEXT NOT NULL, `backdrop` TEXT, `originalTitle` TEXT NOT NULL, `originalLanguage` TEXT NOT NULL, `popularity` REAL NOT NULL, `voteAverage` REAL NOT NULL, `isFavorite` INTEGER NOT NULL)")
        connection.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)")
        connection.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'caca85dc4dd8f1bf51030029c5ab6df2')")
      }

      public override fun dropAllTables(connection: SQLiteConnection) {
        connection.execSQL("DROP TABLE IF EXISTS `Movie`")
      }

      public override fun onCreate(connection: SQLiteConnection) {
      }

      public override fun onOpen(connection: SQLiteConnection) {
        internalInitInvalidationTracker(connection)
      }

      public override fun onPreMigrate(connection: SQLiteConnection) {
        dropFtsSyncTriggers(connection)
      }

      public override fun onPostMigrate(connection: SQLiteConnection) {
      }

      public override fun onValidateSchema(connection: SQLiteConnection):
          RoomOpenDelegate.ValidationResult {
        val _columnsMovie: MutableMap<String, TableInfo.Column> = mutableMapOf()
        _columnsMovie.put("id", TableInfo.Column("id", "INTEGER", true, 1, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsMovie.put("title", TableInfo.Column("title", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsMovie.put("overview", TableInfo.Column("overview", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsMovie.put("releaseDate", TableInfo.Column("releaseDate", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsMovie.put("poster", TableInfo.Column("poster", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsMovie.put("backdrop", TableInfo.Column("backdrop", "TEXT", false, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsMovie.put("originalTitle", TableInfo.Column("originalTitle", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsMovie.put("originalLanguage", TableInfo.Column("originalLanguage", "TEXT", true, 0,
            null, TableInfo.CREATED_FROM_ENTITY))
        _columnsMovie.put("popularity", TableInfo.Column("popularity", "REAL", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsMovie.put("voteAverage", TableInfo.Column("voteAverage", "REAL", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsMovie.put("isFavorite", TableInfo.Column("isFavorite", "INTEGER", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        val _foreignKeysMovie: MutableSet<TableInfo.ForeignKey> = mutableSetOf()
        val _indicesMovie: MutableSet<TableInfo.Index> = mutableSetOf()
        val _infoMovie: TableInfo = TableInfo("Movie", _columnsMovie, _foreignKeysMovie,
            _indicesMovie)
        val _existingMovie: TableInfo = read(connection, "Movie")
        if (!_infoMovie.equals(_existingMovie)) {
          return RoomOpenDelegate.ValidationResult(false, """
              |Movie(com.corack.shared.models.Movie).
              | Expected:
              |""".trimMargin() + _infoMovie + """
              |
              | Found:
              |""".trimMargin() + _existingMovie)
        }
        return RoomOpenDelegate.ValidationResult(true, null)
      }
    }
    return _openDelegate
  }

  protected override fun createInvalidationTracker(): InvalidationTracker {
    val _shadowTablesMap: MutableMap<String, String> = mutableMapOf()
    val _viewTables: MutableMap<String, Set<String>> = mutableMapOf()
    return InvalidationTracker(this, _shadowTablesMap, _viewTables, "Movie")
  }

  protected override fun getRequiredTypeConverterClasses(): Map<KClass<*>, List<KClass<*>>> {
    val _typeConvertersMap: MutableMap<KClass<*>, List<KClass<*>>> = mutableMapOf()
    _typeConvertersMap.put(MoviesDao::class, MoviesDao_Impl.getRequiredConverters())
    return _typeConvertersMap
  }

  public override fun getRequiredAutoMigrationSpecClasses(): Set<KClass<out AutoMigrationSpec>> {
    val _autoMigrationSpecsSet: MutableSet<KClass<out AutoMigrationSpec>> = mutableSetOf()
    return _autoMigrationSpecsSet
  }

  public override
      fun createAutoMigrations(autoMigrationSpecs: Map<KClass<out AutoMigrationSpec>, AutoMigrationSpec>):
      List<Migration> {
    val _autoMigrations: MutableList<Migration> = mutableListOf()
    return _autoMigrations
  }

  public override fun moviesDao(): MoviesDao = _moviesDao.value
}
