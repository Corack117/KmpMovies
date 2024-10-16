package com.corack.shared.data

import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.os.Build
import androidx.annotation.FloatRange
import com.google.android.gms.location.FusedLocationProviderClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withContext
import kotlin.coroutines.resume

class AndroidRegionDataSource(
    private val geocoder: Geocoder,
    private val fusedLocationClient: FusedLocationProviderClient
): RegionDataSource {
    override suspend fun fetchRegion(): String {
        return fusedLocationClient.lastLocation()?.toRegion()!!
    }

    private suspend fun Location.toRegion(): String {
        val addresses = geocoder.getFromLocationCompact(latitude, longitude, 1)
        return  addresses.firstOrNull()?.countryCode ?: DEFAULT_REGION
    }
}

private suspend  fun FusedLocationProviderClient.lastLocation(): Location? {
    return suspendCancellableCoroutine { continuation ->
        lastLocation.addOnSuccessListener {
            continuation.resume(it)
        }.addOnFailureListener {
            continuation.resume(null)
        }
    }
}

@Suppress("DEPRECATION")
suspend fun Geocoder.getFromLocationCompact(
    @FloatRange(from = -90.0, to = 90.0) latitude: Double,
    @FloatRange(from = -180.0, to = 180.0) longitude: Double,
    maxResult: Int
): List<Address> = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
    suspendCancellableCoroutine { continuation ->
        getFromLocation(latitude, longitude, maxResult) {
            continuation.resume(it)
        }
    }
} else {
    withContext(Dispatchers.IO) {
        getFromLocation(latitude, longitude, maxResult) ?: emptyList()
    }
}