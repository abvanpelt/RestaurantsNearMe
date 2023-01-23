package com.abvanpelt.restaurantsnearme.repository

import com.abvanpelt.restaurantsnearme.ui.data.LatLong
import java.util.Optional

interface LocationRepository {

    /*
     * Get the user's location.
     */
    suspend fun getLastLocation(): Optional<LatLong>
}