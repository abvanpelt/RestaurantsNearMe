package com.abvanpelt.restaurantsnearme.network

import com.abvanpelt.restaurantsnearme.network.data.PlacesSearchResponse
import com.abvanpelt.restaurantsnearme.ui.data.LatLong
import com.abvanpelt.restaurantsnearme.ui.data.Place

object PlacesMapper {

    fun toPlace(result: PlacesSearchResponse.Result): Place {
        return Place(
            id = result.placeId ?: throw Exception("Place ID cannot be null"),
            name = result.name.orEmpty(),
            latLong = LatLong(
                latitude = result.geometry?.location?.lat ?: 0.0,
                longitude = result.geometry?.location?.lng ?: 0.0
            ),
            rating = result.rating ?: 0.0F,
            numRatings = result.userRatingsTotal ?: 0
        )
    }
}