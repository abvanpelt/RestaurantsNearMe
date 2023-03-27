package com.abvanpelt.restaurantsnearme.repository

import com.abvanpelt.restaurantsnearme.network.PlacesApi
import com.abvanpelt.restaurantsnearme.ui.data.LatLong
import com.abvanpelt.restaurantsnearme.ui.data.Place
import javax.inject.Inject

class PlacesRepositoryImpl @Inject constructor(
    private val placesApi: PlacesApi
) : PlacesRepository {

    override suspend fun getNearbyPlaces(latLong: LatLong): List<Place> {
        return emptyList()
    }
}