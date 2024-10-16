package com.corack.kmpmovies

import com.corack.kmpmovies.models.DetailViewModel
import com.corack.kmpmovies.models.MainViewModel
import com.corack.kmpmovies.services.MovieService
import com.corack.kmpmovies.services.RegionRepository
import com.corack.shared.database.MoviesDao
import com.corack.shared.database.MoviesDatabase
import com.corack.shared.nativeModule
import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.factoryOf
import org.koin.core.qualifier.named
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

val appModule = module {
    single(named("apiKey")) { BuildConfig.API_KEY }
    single<MoviesDao> {
        val dbBuilder = get<MoviesDatabase>()
        dbBuilder.moviesDao()
    }
}

val dataMode = module {
    // oldVersion
    // factory { MovieService(get(), get()) }
    factoryOf(::MovieService)
    factoryOf(::RegionRepository)
    single<HttpClient> {
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
                    parameters.append("api_key", BuildConfig.API_KEY)
                }
            }
        }
    }
}

val viewModelsModule = module {
    viewModelOf(::MainViewModel)
    viewModelOf(::DetailViewModel)
}

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(appModule, dataMode, viewModelsModule, nativeModule)
    }
}