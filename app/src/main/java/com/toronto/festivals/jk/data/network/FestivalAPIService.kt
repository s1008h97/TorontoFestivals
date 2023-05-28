package com.toronto.festivals.jk.data.network

import com.toronto.festivals.jk.data.model.FestivalCalEventModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface FestivalAPIService {

    @GET("cc_sr_v1/data/{path}")
    fun getFestivalCalEventJson(
        @Path("path") path : String
    ):Call<FestivalCalEventModel>
}