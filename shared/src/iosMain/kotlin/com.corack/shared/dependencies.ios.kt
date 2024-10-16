package com.corack.shared

import com.corack.shared.data.IosRegionDataSource
import com.corack.shared.data.RegionDataSource
import com.corack.shared.database.getDatabaseBuilder
import org.koin.core.module.Module
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

actual val nativeModule: Module = module {
    single { getDatabaseBuilder() }
    factoryOf(::IosRegionDataSource) bind RegionDataSource::class
}