package com.corack.shared.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
@Entity
actual data class Movie actual constructor(
    @PrimaryKey(autoGenerate = true)
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