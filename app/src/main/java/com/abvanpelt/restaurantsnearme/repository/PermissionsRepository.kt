package com.abvanpelt.restaurantsnearme.repository

import kotlinx.coroutines.flow.Flow

interface PermissionsRepository {

    /*
     * Get the location permission.
     * Returns true if the user has granted location permission to the app.
     */
    fun getLocationPermission(): Flow<Boolean>

    /*
     * Set the location permission.
     */
    fun setLocationPermission(hasLocationPermission: Boolean)
}