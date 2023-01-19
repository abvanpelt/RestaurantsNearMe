package com.abvanpelt.restaurantsnearme.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.abvanpelt.restaurantsnearme.R
import com.abvanpelt.restaurantsnearme.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

const val INDEX_FRAGMENT_MAP = 0
const val INDEX_FRAGMENT_LIST = 1

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

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
}