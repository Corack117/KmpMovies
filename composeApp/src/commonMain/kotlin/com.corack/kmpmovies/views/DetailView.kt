package com.corack.kmpmovies.views

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.corack.kmpmovies.components.DetailTopBar
import com.corack.kmpmovies.components.LoadingIndicator
import com.corack.kmpmovies.components.MovieDetail
import com.corack.kmpmovies.models.DetailViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun DetailView(vm: DetailViewModel, onBack: () -> Unit) {
    val state = vm.state
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    Scaffold (
        topBar = {
            DetailTopBar(
                title = state.movie?.title ?: "",
                onBack = onBack,
                scrollBehavior = scrollBehavior
            )
        },
    ) { innerPadding ->
        LoadingIndicator(
            enabled = state.loading,
            modifier = Modifier
                .padding(innerPadding)
        )

        state.movie?.let { movie ->
            MovieDetail(
                movie = movie,
                modifier = Modifier
                    .padding(innerPadding)
            )
        }
    }
}

