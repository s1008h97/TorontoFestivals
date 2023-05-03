package com.toronto.festivals.jk.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.toronto.festivals.jk.model.FestivalsModel


class FestivalsViewModel : ViewModel() {

    private val _liveData = MutableLiveData<String>()
    val liveData: LiveData<String> = _liveData

    init {
        _liveData.value = "Hello World! Click text!"
    }

    fun increment(text: String?) {
        _liveData.value = text
    }
}