package com.corack.shared.models

expect class Movie(
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
) {
    val id: Int
    val title: String
    val overview: String
    val releaseDate: String
    val poster: String
    val backdrop: String?
    val originalTitle: String
    val originalLanguage: String
    val popularity: Double
    val voteAverage: Double
    var isFavorite: Boolean

    fun update(
        id: Int = this.id,
        title: String = this.title,
        overview: String = this.overview,
        releaseDate: String = this.releaseDate,
        poster: String = this.poster,
        backdrop: String? = this.backdrop,
        originalTitle: String = this.originalTitle,
        originalLanguage: String = this.originalLanguage,
        popularity: Double = this.popularity,
        voteAverage: Double = this.voteAverage,
        isFavorite: Boolean = this.isFavorite
    ): Movie
}
