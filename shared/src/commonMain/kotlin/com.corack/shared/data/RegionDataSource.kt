package com.corack.shared.data

interface RegionDataSource {
    suspend fun fetchRegion(): String
}

const val DEFAULT_REGION = "US"