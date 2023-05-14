package com.toronto.festivals.jk.util

import android.os.SystemClock
import android.view.View

abstract class OnSingleClickListener : View.OnClickListener {
    private var mLastClickTime: Long = 0
    abstract fun onSingleClick(view: View?)
    override fun onClick(view: View) {
        val currentClickTime = SystemClock.uptimeMillis()
        val elapsedTime = currentClickTime - mLastClickTime
        mLastClickTime = currentClickTime

        // 중복 클릭인 경우
        if (elapsedTime <= MIN_CLICK_INTERVAL) {
            return
        }

        // 중복 클릭이 아니라면 추상함수 호출
        onSingleClick(view)
    }

    companion object {
        // 중복 클릭 방지 시간 설정
        private const val MIN_CLICK_INTERVAL: Long = 600
    }
}
