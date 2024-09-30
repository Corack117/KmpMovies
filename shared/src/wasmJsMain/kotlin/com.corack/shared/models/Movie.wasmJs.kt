package com.corack.shared.models

actual data class Movie actual constructor(
    actual val id: Int,
    actual val title: String,
    actual val overview: String,
    actual val releaseDate: String,
    actual val poster: String,
    actual val backdrop: String?,
    actual val originalTitle: String,
    actual val originalLanguage: String,
    actual val popularity: Double,
    actual val voteAverage: Double,
    actual var isFavorite: Boolean
) {
    actual fun update(
        id: Int,
        title: String,
        overview: String,
        releaseDate: String,
        poster: String,
        backdrop: String?,
        originalTitle: String,
        originalLanguage: String,
        popularity: Double,
        voteAverage: Double,
        isFavorite: Boolean
    ): Movie {
        return this.copy(
            id = id,
            title = title,
            overview = overview,
            releaseDate = releaseDate,
            poster = poster,
            backdrop = backdrop,
            originalTitle = originalTitle,
            originalLanguage = originalLanguage,
            popularity = popularity,
            voteAverage = voteAverage,
            isFavorite = isFavorite
        )
    }
}