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
    voteAverage: Double
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
}
