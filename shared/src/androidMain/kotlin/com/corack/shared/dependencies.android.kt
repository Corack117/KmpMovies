package com.corack.shared

import android.location.Geocoder
import com.corack.shared.data.AndroidRegionDataSource
import com.corack.shared.data.RegionDataSource
import com.corack.shared.database.getDatabaseBuilder
import com.google.android.gms.location.LocationServices
import org.koin.core.module.Module
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.android.ext.koin.androidContext

actual val nativeModule: Module = module {
    single { getDatabaseBuilder(get()) }
    factory { Geocoder(get()) }
    factory { LocationServices.getFusedLocationProviderClient(androidContext()) }
    factoryOf(::AndroidRegionDataSource) bind RegionDataSource::class
}