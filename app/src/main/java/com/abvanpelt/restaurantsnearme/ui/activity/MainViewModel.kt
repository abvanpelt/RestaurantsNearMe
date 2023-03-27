package com.abvanpelt.restaurantsnearme.ui.activity

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abvanpelt.restaurantsnearme.repository.LocationRepository
import com.abvanpelt.restaurantsnearme.repository.PlacesRepository
import com.abvanpelt.restaurantsnearme.ui.data.LatLong
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val locationRepository: LocationRepository,
    private val placesRepository: PlacesRepository
) : ViewModel() {

    private val locationLiveData = MutableLiveData<LatLong>()

    /*
     * Returns a [LiveData] object that will provide [LatLong] data
     * to any observers.
     */
    val location: LiveData<LatLong> get() = locationLiveData

    fun onPermissionResult(hasLocationPermission: Boolean) {
        if (hasLocationPermission) {
            viewModelScope.launch {
                val latLong = locationRepository.getLastLocation()
                if (latLong.isPresent) {
                    Log.v(
                        "RestaurantsNearMe",
                        "Got user location: ${latLong.get().latitude}, ${latLong.get().longitude}"
                    )

                    locationLiveData.value = latLong.get()
                } else {
                    Log.v("RestaurantsNearMe", "Failed to retrieve user location")
                }
            }
        }
    }
}