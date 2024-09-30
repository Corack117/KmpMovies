package com.corack.kmpmovies.views

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.corack.kmpmovies.components.DetailTopBar
import com.corack.kmpmovies.components.LoadingIndicator
import com.corack.kmpmovies.components.MovieDetail
import com.corack.kmpmovies.models.DetailViewModel
import com.corack.shared.getPlatform
import kmpmovies.composeapp.generated.resources.Res
import kmpmovies.composeapp.generated.resources.favorite
import org.jetbrains.compose.resources.stringResource
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
        floatingActionButton = {
            if (!getPlatform().name.contains("Web")) {
                state.movie?.let {
                    FloatingActionButton(
                        onClick = vm::onFavoriteClick,
                    ) {
                        Icon(
                            imageVector = if (it.isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                            contentDescription = stringResource(Res.string.favorite)
                        )
                    }
                }
            }
        }
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

