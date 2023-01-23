package com.abvanpelt.restaurantsnearme.repository

import android.annotation.SuppressLint
import com.abvanpelt.restaurantsnearme.ui.data.LatLong
import com.google.android.gms.location.FusedLocationProviderClient
import java.util.*
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class LocationRepositoryImpl @Inject constructor(
    private val fusedLocationProviderClient: FusedLocationProviderClient
) : LocationRepository {

    // This method is only called when we have been granted location permission.
    @SuppressLint("MissingPermission")
    override suspend fun getLastLocation(): Optional<LatLong> {
        return suspendCoroutine { continuation ->
            fusedLocationProviderClient.lastLocation
                .addOnSuccessListener { location ->
                    continuation.resume(
                        location?.let {
                            Optional.of(LatLong(it.latitude, it.longitude))
                        } ?: Optional.empty<LatLong>()
                    )
                }
                .addOnFailureListener {
                    continuation.resumeWithException(it)
                }
        }
    }
}