package com.abvanpelt.restaurantsnearme.network

object PlacesApiFields {
    // Endpoints
    const val PLACES_NEARBY_SEARCH = "maps/api/place/nearbysearch/json"

    // Query parameters
    const val PLACES_PARAM_LOCATION = "location"
    const val PLACES_PARAM_KEY = "key"
    const val PLACES_PARAM_RADIUS = "radius"
    const val PLACES_PARAM_TYPE = "type"

    // Default query values
    const val PLACES_DEFAULT_RADIUS = "32200" // Approximately 20 mile radius, in meters.
    const val PLACES_DEFAULT_TYPE = "restaurant"

    // Response fields
    const val PLACES_RESPONSE_ATTRIBUTIONS = "html_attributions"
    const val PLACES_RESPONSE_RESULTS = "results"
    const val PLACES_RESPONSE_STATUS = "status"
    const val PLACES_RESPONSE_GEOMETRY = "geometry"
    const val PLACES_RESPONSE_NAME = "name"
    const val PLACES_RESPONSE_PLACE_ID = "place_id"
    const val PLACES_RESPONSE_RATING = "rating"
    const val PLACES_RESPONSE_SUMMARY = "editorial_summary"
    const val PLACES_RESPONSE_RATINGS_TOTAL = "user_ratings_total"
    const val PLACES_RESPONSE_LOCATION = "location"
    const val PLACES_RESPONSE_LAT = "lat"
    const val PLACES_RESPONSE_LNG = "lng"
}