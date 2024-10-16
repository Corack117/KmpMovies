package com.corack.shared.data

class IosRegionDataSource: RegionDataSource {
    override suspend fun fetchRegion(): String {
        return "US"
    }
}