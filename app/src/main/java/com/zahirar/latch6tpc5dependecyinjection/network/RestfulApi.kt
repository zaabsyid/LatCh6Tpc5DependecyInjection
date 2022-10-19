package com.zahirar.latch6tpc5dependecyinjection.network

import com.zahirar.latch6tpc5dependecyinjection.model.GetMakeUpResponseItem
import retrofit2.Call
import retrofit2.http.GET

interface RestfulApi {
    @GET("api/v1/products.json/")
    fun getAllMakeUp() : Call<List<GetMakeUpResponseItem>>
}