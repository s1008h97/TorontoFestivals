package com.toronto.festivals.jk.data.model

import androidx.databinding.ObservableField
import com.google.gson.annotations.SerializedName


class FestivalsModel {
    val id = ObservableField<String>()
    val img = ObservableField<String>()
    val title = ObservableField<String>()

}