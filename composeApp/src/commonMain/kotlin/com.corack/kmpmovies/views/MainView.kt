package com.corack.kmpmovies.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.corack.kmpmovies.components.LoadingIndicator
import com.corack.kmpmovies.components.MovieItem
import com.corack.kmpmovies.models.MainViewModel
import kmpmovies.composeapp.generated.resources.Res
import kmpmovies.composeapp.generated.resources.app_name
import org.jetbrains.compose.resources.stringResource


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainView(
    navController: NavController,
    vm: MainViewModel
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    val state = vm.state

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(Res.string.app_name)) },
                scrollBehavior = scrollBehavior
            )
        },
        modifier = Modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection)
    ) { innerPadding ->
        LoadingIndicator(
            enabled = state.loading,
            modifier = Modifier
                .padding(innerPadding)
        )

        LazyVerticalGrid(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            contentPadding = PaddingValues(4.dp),
            columns = GridCells.Adaptive(120.dp),
            modifier = Modifier.padding(innerPadding)
        ) {
            items(state.movies, key = { it.id }) {
                MovieItem(navController, movie = it)
            }
        }
    }
}