package com.toronto.festivals.jk.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.toronto.festivals.jk.R
import com.toronto.festivals.jk.databinding.ActivityMainBinding
import com.toronto.festivals.jk.util.OnSingleClickListener

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var pagerAdapter: PagerAdapter

    var mapFragment: MapFragment? = null
    var festivalsFragment: FestivalsFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setUpFragment()
    }

    // Fragment Setting
    private fun setUpFragment() {
        pagerAdapter = ScreenSlidePagerAdapter(supportFragmentManager, 1)
        binding.viewPager.adapter = pagerAdapter

        pagerAdapter.startUpdate(binding.viewPager)
        mapFragment = pagerAdapter.instantiateItem(binding.viewPager, 0) as MapFragment
        festivalsFragment = pagerAdapter.instantiateItem(binding.viewPager, 1) as FestivalsFragment
        binding.viewPager.addOnPageChangeListener(mOnPageChangeListener)

        binding.tabMain.setOnClickListener(object : OnSingleClickListener() {
            override fun onSingleClick(view: View?) {
                binding.viewPager.currentItem = 0
            }
        })
        binding.tabMap.setOnClickListener(object : OnSingleClickListener() {
            override fun onSingleClick(view: View?) {
                binding.viewPager.currentItem = 1
            }
        })
    }

    private class ScreenSlidePagerAdapter(fm: FragmentManager, behavior: Int) :
        FragmentStatePagerAdapter(fm, behavior) {
        override fun getItem(position: Int): Fragment {
            return when (position) {
                0 -> MapFragment()
                1 -> FestivalsFragment()
                else -> return MapFragment()
            }
        }

        override fun getCount(): Int {
            return 2
        }
    }

    private val mOnPageChangeListener: OnPageChangeListener = object : OnPageChangeListener {
        override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int
        ) {
        }

        override fun onPageSelected(position: Int) {
            if (position == 0) {
                binding.tabMain.setTextColor(resources.getColor(R.color.black))
                binding.tabMap.setTextColor(resources.getColor(R.color.colorE0E0E0))
            } else if (position == 1) {
                binding.tabMap.setTextColor(resources.getColor(R.color.black))
                binding.tabMain.setTextColor(resources.getColor(R.color.colorE0E0E0))
            }
        }

        override fun onPageScrollStateChanged(state: Int) {}
    }

}
