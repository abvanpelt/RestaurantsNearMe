package com.abvanpelt.restaurantsnearme.ui.activity

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    fun onPermissionResult(hasLocationPermission: Boolean) {
        // TODO forward the information to the Repository
    }
}