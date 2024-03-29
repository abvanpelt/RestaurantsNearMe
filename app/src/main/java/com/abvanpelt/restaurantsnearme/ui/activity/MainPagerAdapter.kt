package com.abvanpelt.restaurantsnearme.ui.activity

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.abvanpelt.restaurantsnearme.ui.fragment.PlacesListFragment
import com.abvanpelt.restaurantsnearme.ui.fragment.PlacesMapFragment

private const val FRAGMENT_COUNT = 2

class MainPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount() = FRAGMENT_COUNT

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            INDEX_FRAGMENT_MAP -> PlacesMapFragment()
            INDEX_FRAGMENT_LIST -> PlacesListFragment()
            else -> throw IllegalStateException("Unexpected ViewPager position: $position")
        }
    }
}