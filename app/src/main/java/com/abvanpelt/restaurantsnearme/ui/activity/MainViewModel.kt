package com.abvanpelt.restaurantsnearme.ui.activity

import androidx.lifecycle.ViewModel
import com.abvanpelt.restaurantsnearme.repository.PermissionsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val permissionsRepository: PermissionsRepository
): ViewModel() {

    fun onPermissionResult(hasLocationPermission: Boolean) {
        // TODO forward the information to the Repository
    }
}