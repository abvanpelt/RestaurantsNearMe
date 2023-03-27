package com.abvanpelt.restaurantsnearme.ui.data

data class Place(
    val id: String,
    val name: String,
    val latLong: LatLong,
    val rating: Float,
    val numRatings: Int
)
