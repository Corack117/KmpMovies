package com.corack.kmpmovies.services

import com.corack.shared.data.RegionDataSource

class RegionRepository(
    private val regionDataSource: RegionDataSource
) {
    suspend fun fetchRegion(): String {
        return regionDataSource.fetchRegion()
    }
}