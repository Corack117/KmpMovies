package com.corack.kmpmovies

import androidx.compose.ui.window.ComposeUIViewController
import com.corack.kmpmovies.App
import com.corack.shared.database.getDatabaseBuilder

fun MainViewController() = ComposeUIViewController {
    val db = getDatabaseBuilder().build()
    App(moviesDao =  db.moviesDao())
}