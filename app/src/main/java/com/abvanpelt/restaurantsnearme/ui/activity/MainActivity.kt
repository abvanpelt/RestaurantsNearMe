package com.abvanpelt.restaurantsnearme.ui.activity

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.abvanpelt.restaurantsnearme.R
import com.abvanpelt.restaurantsnearme.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

const val INDEX_FRAGMENT_MAP = 0
const val INDEX_FRAGMENT_LIST = 1

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        with(binding.viewPager) {
            adapter = MainPagerAdapter(this@MainActivity)

            TabLayoutMediator(binding.tabLayout, this) { tab, position ->
                when (position) {
                    INDEX_FRAGMENT_MAP -> tab.text = getString(R.string.tab_map)
                    INDEX_FRAGMENT_LIST -> tab.text = getString(R.string.tab_list)
                    else -> throw IllegalStateException("Unexpected tab position: $position")
                }
            }.attach()
        }

        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        checkLocationPermission()
    }

    /*
     * Check whether or not we were already granted location permission from the user.
     * If not, request the permission.
     */
    private fun checkLocationPermission() {
        val request = registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            viewModel.onPermissionResult(it)
        }

        when {
            hasLocationPermission() -> {
                viewModel.onPermissionResult(true)
            }
            showPermissionExplanation() -> {
                Snackbar
                    .make(binding.root, R.string.text_permission, Snackbar.LENGTH_INDEFINITE)
                    .setAction(R.string.text_ok) {
                        request.launch(Manifest.permission.ACCESS_COARSE_LOCATION)
                    }
                    .show()
            }
            else -> request.launch(Manifest.permission.ACCESS_COARSE_LOCATION)
        }
    }

    /*
     * Returns true if the user has granted location permission to the app.
     */
    private fun hasLocationPermission(): Boolean {
        return ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
    }

    /*
     * Returns true if we should display a rationale for the location permission request.
     */
    private fun showPermissionExplanation(): Boolean {
        return ActivityCompat.shouldShowRequestPermissionRationale(
            this,
            Manifest.permission.ACCESS_COARSE_LOCATION
        )
    }
}