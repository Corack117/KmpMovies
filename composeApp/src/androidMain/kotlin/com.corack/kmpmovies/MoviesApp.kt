package com.corack.kmpmovies

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level

class MoviesApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@MoviesApp)
        }
    }
}