package com.corack.shared.database

import androidx.room.EntityInsertAdapter
import androidx.room.RoomDatabase
import androidx.room.coroutines.createFlow
import androidx.room.util.getColumnIndexOrThrow
import androidx.room.util.performSuspending
import androidx.sqlite.SQLiteStatement
import com.corack.shared.models.Movie
import javax.`annotation`.processing.Generated
import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlin.collections.mutableListOf
import kotlin.reflect.KClass
import kotlinx.coroutines.flow.Flow

@Generated(value = ["androidx.room.RoomProcessor"])
@Suppress(names = ["UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION", "REMOVAL"])
public class MoviesDao_Impl(
  __db: RoomDatabase,
) : MoviesDao {
  private val __db: RoomDatabase

  private val __insertAdapterOfMovie: EntityInsertAdapter<Movie>
  init {
    this.__db = __db
    this.__insertAdapterOfMovie = object : EntityInsertAdapter<Movie>() {
      protected override fun createQuery(): String =
          "INSERT OR REPLACE INTO `Movie` (`id`,`title`,`overview`,`releaseDate`,`poster`,`backdrop`,`originalTitle`,`originalLanguage`,`popularity`,`voteAverage`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)"

      protected override fun bind(statement: SQLiteStatement, entity: Movie) {
        statement.bindLong(1, entity.id.toLong())
        statement.bindText(2, entity.title)
        statement.bindText(3, entity.overview)
        statement.bindText(4, entity.releaseDate)
        statement.bindText(5, entity.poster)
        val _tmpBackdrop: String? = entity.backdrop
        if (_tmpBackdrop == null) {
          statement.bindNull(6)
        } else {
          statement.bindText(6, _tmpBackdrop)
        }
        statement.bindText(7, entity.originalTitle)
        statement.bindText(8, entity.originalLanguage)
        statement.bindDouble(9, entity.popularity)
        statement.bindDouble(10, entity.voteAverage)
      }
    }
  }

  public override suspend fun save(movies: List<Movie>): Unit = performSuspending(__db, false, true)
      { _connection ->
    __insertAdapterOfMovie.insert(_connection, movies)
  }

  public override fun fetchPopularMovies(): Flow<List<Movie>> {
    val _sql: String = "SELECT * FROM Movie"
    return createFlow(__db, false, arrayOf("Movie")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        val _cursorIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _cursorIndexOfTitle: Int = getColumnIndexOrThrow(_stmt, "title")
        val _cursorIndexOfOverview: Int = getColumnIndexOrThrow(_stmt, "overview")
        val _cursorIndexOfReleaseDate: Int = getColumnIndexOrThrow(_stmt, "releaseDate")
        val _cursorIndexOfPoster: Int = getColumnIndexOrThrow(_stmt, "poster")
        val _cursorIndexOfBackdrop: Int = getColumnIndexOrThrow(_stmt, "backdrop")
        val _cursorIndexOfOriginalTitle: Int = getColumnIndexOrThrow(_stmt, "originalTitle")
        val _cursorIndexOfOriginalLanguage: Int = getColumnIndexOrThrow(_stmt, "originalLanguage")
        val _cursorIndexOfPopularity: Int = getColumnIndexOrThrow(_stmt, "popularity")
        val _cursorIndexOfVoteAverage: Int = getColumnIndexOrThrow(_stmt, "voteAverage")
        val _result: MutableList<Movie> = mutableListOf()
        while (_stmt.step()) {
          val _item: Movie
          val _tmpId: Int
          _tmpId = _stmt.getLong(_cursorIndexOfId).toInt()
          val _tmpTitle: String
          _tmpTitle = _stmt.getText(_cursorIndexOfTitle)
          val _tmpOverview: String
          _tmpOverview = _stmt.getText(_cursorIndexOfOverview)
          val _tmpReleaseDate: String
          _tmpReleaseDate = _stmt.getText(_cursorIndexOfReleaseDate)
          val _tmpPoster: String
          _tmpPoster = _stmt.getText(_cursorIndexOfPoster)
          val _tmpBackdrop: String?
          if (_stmt.isNull(_cursorIndexOfBackdrop)) {
            _tmpBackdrop = null
          } else {
            _tmpBackdrop = _stmt.getText(_cursorIndexOfBackdrop)
          }
          val _tmpOriginalTitle: String
          _tmpOriginalTitle = _stmt.getText(_cursorIndexOfOriginalTitle)
          val _tmpOriginalLanguage: String
          _tmpOriginalLanguage = _stmt.getText(_cursorIndexOfOriginalLanguage)
          val _tmpPopularity: Double
          _tmpPopularity = _stmt.getDouble(_cursorIndexOfPopularity)
          val _tmpVoteAverage: Double
          _tmpVoteAverage = _stmt.getDouble(_cursorIndexOfVoteAverage)
          _item =
              Movie(_tmpId,_tmpTitle,_tmpOverview,_tmpReleaseDate,_tmpPoster,_tmpBackdrop,_tmpOriginalTitle,_tmpOriginalLanguage,_tmpPopularity,_tmpVoteAverage)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override fun fetchMovieById(id: Int): Flow<Movie?> {
    val _sql: String = "SELECT * FROM Movie WHERE id = ?"
    return createFlow(__db, false, arrayOf("Movie")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindLong(_argIndex, id.toLong())
        val _cursorIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _cursorIndexOfTitle: Int = getColumnIndexOrThrow(_stmt, "title")
        val _cursorIndexOfOverview: Int = getColumnIndexOrThrow(_stmt, "overview")
        val _cursorIndexOfReleaseDate: Int = getColumnIndexOrThrow(_stmt, "releaseDate")
        val _cursorIndexOfPoster: Int = getColumnIndexOrThrow(_stmt, "poster")
        val _cursorIndexOfBackdrop: Int = getColumnIndexOrThrow(_stmt, "backdrop")
        val _cursorIndexOfOriginalTitle: Int = getColumnIndexOrThrow(_stmt, "originalTitle")
        val _cursorIndexOfOriginalLanguage: Int = getColumnIndexOrThrow(_stmt, "originalLanguage")
        val _cursorIndexOfPopularity: Int = getColumnIndexOrThrow(_stmt, "popularity")
        val _cursorIndexOfVoteAverage: Int = getColumnIndexOrThrow(_stmt, "voteAverage")
        val _result: Movie?
        if (_stmt.step()) {
          val _tmpId: Int
          _tmpId = _stmt.getLong(_cursorIndexOfId).toInt()
          val _tmpTitle: String
          _tmpTitle = _stmt.getText(_cursorIndexOfTitle)
          val _tmpOverview: String
          _tmpOverview = _stmt.getText(_cursorIndexOfOverview)
          val _tmpReleaseDate: String
          _tmpReleaseDate = _stmt.getText(_cursorIndexOfReleaseDate)
          val _tmpPoster: String
          _tmpPoster = _stmt.getText(_cursorIndexOfPoster)
          val _tmpBackdrop: String?
          if (_stmt.isNull(_cursorIndexOfBackdrop)) {
            _tmpBackdrop = null
          } else {
            _tmpBackdrop = _stmt.getText(_cursorIndexOfBackdrop)
          }
          val _tmpOriginalTitle: String
          _tmpOriginalTitle = _stmt.getText(_cursorIndexOfOriginalTitle)
          val _tmpOriginalLanguage: String
          _tmpOriginalLanguage = _stmt.getText(_cursorIndexOfOriginalLanguage)
          val _tmpPopularity: Double
          _tmpPopularity = _stmt.getDouble(_cursorIndexOfPopularity)
          val _tmpVoteAverage: Double
          _tmpVoteAverage = _stmt.getDouble(_cursorIndexOfVoteAverage)
          _result =
              Movie(_tmpId,_tmpTitle,_tmpOverview,_tmpReleaseDate,_tmpPoster,_tmpBackdrop,_tmpOriginalTitle,_tmpOriginalLanguage,_tmpPopularity,_tmpVoteAverage)
        } else {
          _result = null
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public companion object {
    public fun getRequiredConverters(): List<KClass<*>> = emptyList()
  }
}
