package com.abvanpelt.restaurantsnearme.ui.activity

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abvanpelt.restaurantsnearme.repository.LocationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val locationRepository: LocationRepository
) : ViewModel() {

    fun onPermissionResult(hasLocationPermission: Boolean) {
        if (hasLocationPermission) {
            viewModelScope.launch {
                val latLong = locationRepository.getLastLocation()
                if (latLong.isPresent) {
                    Log.v(
                        "RestaurantsNearMe",
                        "Got user location: ${latLong.get().latitude}, ${latLong.get().longitude}"
                    )
                } else {
                    Log.v("RestaurantsNearMe", "Failed to retrieve user location")
                }
            }
        }
    }
}