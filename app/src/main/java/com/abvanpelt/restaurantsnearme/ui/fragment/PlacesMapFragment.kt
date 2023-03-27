package com.abvanpelt.restaurantsnearme.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.abvanpelt.restaurantsnearme.databinding.FragmentMapBinding
import com.abvanpelt.restaurantsnearme.ui.activity.MainViewModel
import com.mapbox.geojson.Point
import com.mapbox.maps.CameraOptions

class PlacesMapFragment : Fragment() {

    private var _binding: FragmentMapBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMapBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Observe location updates.
        viewModel.location.observe(viewLifecycleOwner) { latLong ->
            // Center the map on the current location.
            binding.mapView
                .getMapboxMap()
                .setCamera(
                    CameraOptions.Builder()
                        .center(
                            Point.fromLngLat(
                                latLong.longitude,
                                latLong.latitude
                            )
                        )
                        .build()
                )
        }

        viewModel.places.observe(viewLifecycleOwner) { places ->
            // TODO
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}