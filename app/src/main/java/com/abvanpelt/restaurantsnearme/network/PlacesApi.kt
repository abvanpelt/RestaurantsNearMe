package com.abvanpelt.restaurantsnearme.network

import com.abvanpelt.restaurantsnearme.BuildConfig
import com.abvanpelt.restaurantsnearme.network.PlacesApiFields.PLACES_DEFAULT_RADIUS
import com.abvanpelt.restaurantsnearme.network.PlacesApiFields.PLACES_DEFAULT_TYPE
import com.abvanpelt.restaurantsnearme.network.PlacesApiFields.PLACES_NEARBY_SEARCH
import com.abvanpelt.restaurantsnearme.network.PlacesApiFields.PLACES_PARAM_KEY
import com.abvanpelt.restaurantsnearme.network.PlacesApiFields.PLACES_PARAM_LOCATION
import com.abvanpelt.restaurantsnearme.network.PlacesApiFields.PLACES_PARAM_RADIUS
import com.abvanpelt.restaurantsnearme.network.PlacesApiFields.PLACES_PARAM_TYPE
import com.abvanpelt.restaurantsnearme.network.data.PlacesSearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PlacesApi {

    @GET(PLACES_NEARBY_SEARCH)
    suspend fun nearbySearch(
        @Query(PLACES_PARAM_LOCATION) location: String,
        @Query(PLACES_PARAM_KEY) key: String = BuildConfig.PLACES_API_KEY,
        @Query(PLACES_PARAM_RADIUS) radius: String = PLACES_DEFAULT_RADIUS,
        @Query(PLACES_PARAM_TYPE) type: String = PLACES_DEFAULT_TYPE
    ): PlacesSearchResponse
}