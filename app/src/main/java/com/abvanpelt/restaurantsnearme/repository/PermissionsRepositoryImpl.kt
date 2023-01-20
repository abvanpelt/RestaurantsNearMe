package com.abvanpelt.restaurantsnearme.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class PermissionsRepositoryImpl @Inject constructor(): PermissionsRepository {

    private val locationPermissionFlow: MutableStateFlow<Boolean> = MutableStateFlow(false)

    override fun getLocationPermission(): Flow<Boolean> {
        return locationPermissionFlow
    }

    override fun setLocationPermission(hasLocationPermission: Boolean) {
        locationPermissionFlow.value = hasLocationPermission
    }
}