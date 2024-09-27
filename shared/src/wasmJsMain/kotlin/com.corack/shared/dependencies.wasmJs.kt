package com.corack.shared

import com.corack.shared.database.MoviesDaoJVM
import org.koin.core.module.Module
import org.koin.dsl.module

actual val nativeModule: Module = module {
    single { MoviesDaoJVM() }
}