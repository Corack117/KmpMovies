package com.corack.kmpmovies

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.corack.kmpmovies.App
import com.corack.shared.database.getDatabaseBuilder

fun main() = application {
    initKoin {  }
    Window(
        onCloseRequest = ::exitApplication,
        title = "KmpMovies",
    ) {
        val db = getDatabaseBuilder()
        App()
    }
}