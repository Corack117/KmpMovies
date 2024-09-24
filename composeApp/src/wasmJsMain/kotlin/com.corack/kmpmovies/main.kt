package com.corack.kmpmovies

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import com.corack.shared.database.MoviesDaoJVM
import kotlinx.browser.document

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    ComposeViewport(document.body!!) {
        App(moviesDao = MoviesDaoJVM())
    }
}