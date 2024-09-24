package com.corack.kmpmovies

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.corack.kmpmovies.models.DetailViewModel
import com.corack.kmpmovies.models.MainViewModel
import com.corack.kmpmovies.models.MovieService
import com.corack.kmpmovies.views.DetailView
import com.corack.kmpmovies.views.MainView
import com.corack.shared.database.MoviesDao
import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kmpmovies.composeapp.generated.resources.Res
import kmpmovies.composeapp.generated.resources.api_key
import kotlinx.serialization.json.Json
import org.jetbrains.compose.resources.stringResource

@Composable
fun Navigation(moviesDao: MoviesDao, modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val apiKey = stringResource(Res.string.api_key)
    val client = remember(apiKey) {
        if (apiKey.isEmpty()) {
            return@remember null
        }

        HttpClient {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                })
            }
            install(DefaultRequest) {
                url {
                    protocol = URLProtocol.HTTPS
                    host = "api.themoviedb.org"
                    parameters.append("api_key", apiKey)
                }
            }
        }
    }

    client?.let {
        val movieService = MovieService(moviesDao, it)

        NavHost(navController = navController, startDestination = "main") {
            composable("main") {
                MainView(
                    vm = viewModel { MainViewModel(movieService) },
                    navController = navController
                )
            }
            composable(
                route = "details/{movieId}",
                arguments = listOf(navArgument("movieId") { type = NavType.IntType })
            ) { backStackEntry ->
                val movieId = checkNotNull(backStackEntry.arguments?.getInt("movieId"))
                DetailView(
                    vm = viewModel { DetailViewModel(movieId, movieService) },
                    onBack = navController::popBackStack)
            }
        }
    }
}