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
    actual val voteAverage: Double
)