package com.toronto.festivals.jk.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class MapViewModel : ViewModel() {
    private val _data = MutableLiveData<Double>()
    val data: LiveData<Double> get() = _data

    fun updateData(newData: Double) {
        _data.value = newData
    }
    fun getData() = data.value


}