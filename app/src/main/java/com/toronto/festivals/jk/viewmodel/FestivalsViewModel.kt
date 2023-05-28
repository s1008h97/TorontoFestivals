package com.toronto.festivals.jk.viewmodel

import androidx.lifecycle.ViewModel
import androidx.viewpager2.widget.ViewPager2
import java.util.*

class FestivalsViewModel : ViewModel() {
    private var timer: Timer? = null

    // Banner Auto Scroll
    fun startAutoScroll(viewPager: ViewPager2) {
        timer = Timer()
        timer?.schedule(object : TimerTask() {
            override fun run() {
                viewPager.post {
                    val currentItem = viewPager.currentItem
                    val newItem = (currentItem + 1) % 3
                    viewPager.currentItem = newItem
                }
            }
        }, 3000, 3000) // Adjust the delay and period as needed
    }

    fun stopAutoScroll() {
        timer?.cancel()
        timer = null
    }
}