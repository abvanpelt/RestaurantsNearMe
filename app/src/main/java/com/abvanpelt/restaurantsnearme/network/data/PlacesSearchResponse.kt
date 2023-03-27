package com.abvanpelt.restaurantsnearme.network.data

import com.abvanpelt.restaurantsnearme.network.PlacesApiFields.PLACES_RESPONSE_ATTRIBUTIONS
import com.abvanpelt.restaurantsnearme.network.PlacesApiFields.PLACES_RESPONSE_GEOMETRY
import com.abvanpelt.restaurantsnearme.network.PlacesApiFields.PLACES_RESPONSE_LAT
import com.abvanpelt.restaurantsnearme.network.PlacesApiFields.PLACES_RESPONSE_LNG
import com.abvanpelt.restaurantsnearme.network.PlacesApiFields.PLACES_RESPONSE_LOCATION
import com.abvanpelt.restaurantsnearme.network.PlacesApiFields.PLACES_RESPONSE_NAME
import com.abvanpelt.restaurantsnearme.network.PlacesApiFields.PLACES_RESPONSE_PLACE_ID
import com.abvanpelt.restaurantsnearme.network.PlacesApiFields.PLACES_RESPONSE_RATING
import com.abvanpelt.restaurantsnearme.network.PlacesApiFields.PLACES_RESPONSE_RATINGS_TOTAL
import com.abvanpelt.restaurantsnearme.network.PlacesApiFields.PLACES_RESPONSE_RESULTS
import com.abvanpelt.restaurantsnearme.network.PlacesApiFields.PLACES_RESPONSE_STATUS
import com.abvanpelt.restaurantsnearme.network.PlacesApiFields.PLACES_RESPONSE_SUMMARY
import com.squareup.moshi.Json

data class PlacesSearchResponse(
    @field:Json(name = PLACES_RESPONSE_ATTRIBUTIONS) val htmlAttributions: List<String>,
    @field:Json(name = PLACES_RESPONSE_RESULTS) val results: List<Result>,
    @field:Json(name = PLACES_RESPONSE_STATUS) val status: String
) {
    class Result {
        @field:Json(name = PLACES_RESPONSE_GEOMETRY)
        var geometry: Geometry? = null

        @field:Json(name = PLACES_RESPONSE_NAME)
        var name: String? = null

        @field:Json(name = PLACES_RESPONSE_PLACE_ID)
        var placeId: String? = null

        @field:Json(name = PLACES_RESPONSE_RATING)
        var rating: Float? = null

        @field:Json(name = PLACES_RESPONSE_SUMMARY)
        var summary: String? = null

        @field:Json(name = PLACES_RESPONSE_RATINGS_TOTAL)
        var userRatingsTotal: Int? = null
    }

    class Geometry {
        @field:Json(name = PLACES_RESPONSE_LOCATION)
        var location: Location? = null
    }

    class Location {
        @field:Json(name = PLACES_RESPONSE_LAT)
        var lat: Double? = null

        @field:Json(name = PLACES_RESPONSE_LNG)
        var lng: Double? = null
    }
}
