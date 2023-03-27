package com.abvanpelt.restaurantsnearme.repository

import com.abvanpelt.restaurantsnearme.ui.data.LatLong
import com.abvanpelt.restaurantsnearme.ui.data.Place

interface PlacesRepository {

    /*
     * Get nearby places.
     */
    suspend fun getNearbyPlaces(latLong: LatLong): List<Place>
}