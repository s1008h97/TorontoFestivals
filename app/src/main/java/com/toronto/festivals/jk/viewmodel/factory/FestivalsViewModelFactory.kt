package com.toronto.festivals.jk.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.toronto.festivals.jk.viewmodel.FestivalsViewModel

class FestivalsViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FestivalsViewModel::class.java)) {
            return FestivalsViewModel() as T
        }
        throw IllegalArgumentException("뷰모델을 만들 수 없습니다 : IllegalArgumentException")
    }
}