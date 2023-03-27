package com.abvanpelt.restaurantsnearme.repository

import com.abvanpelt.restaurantsnearme.network.PlacesApi
import com.abvanpelt.restaurantsnearme.network.PlacesMapper
import com.abvanpelt.restaurantsnearme.ui.data.LatLong
import com.abvanpelt.restaurantsnearme.ui.data.Place
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PlacesRepositoryImpl @Inject constructor(
    private val ioDispatcher: CoroutineDispatcher,
    private val placesApi: PlacesApi
) : PlacesRepository {

    override suspend fun getNearbyPlaces(latLong: LatLong): List<Place> {
        return withContext(ioDispatcher) {
            placesApi
                .nearbySearch(location = getLocationQuery(latLong))
                .results
                .map { result -> PlacesMapper.toPlace(result) }
        }
    }

    /*
     * Returns a formatted location string.
     */
    private fun getLocationQuery(latLong: LatLong): String {
        return "${latLong.latitude},${latLong.longitude}"
    }
}