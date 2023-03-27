package com.abvanpelt.restaurantsnearme.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.abvanpelt.restaurantsnearme.databinding.FragmentListBinding
import com.abvanpelt.restaurantsnearme.ui.activity.MainViewModel

class PlacesListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!
    private val listAdapter = PlacesListAdapter()

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding.recyclerView) {
            adapter = listAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        viewModel.places.observe(viewLifecycleOwner) { places ->
            listAdapter.submitList(places)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}