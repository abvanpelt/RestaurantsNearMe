package com.abvanpelt.restaurantsnearme.repository

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class PermissionsRepositoryImpl @Inject constructor(
    @ApplicationContext appContext: Context
) : PermissionsRepository {

    private val locationPermissionFlow: MutableStateFlow<Boolean> = MutableStateFlow(
        ContextCompat.checkSelfPermission(
            appContext,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
    )

    override fun getLocationPermission(): Flow<Boolean> {
        return locationPermissionFlow
    }

    override fun setLocationPermission(hasLocationPermission: Boolean) {
        locationPermissionFlow.value = hasLocationPermission
    }
}