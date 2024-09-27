package com.corack.kmpmovies

import androidx.compose.material3.Text
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import com.corack.shared.database.MoviesDaoJVM
import kotlinx.browser.document

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    initKoin {  }
    ComposeViewport(document.body!!) {
        App()
    }
}