package com.demo.weatherdemo.data.api

import com.demo.weatherdemo.data.model.MainData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("forecast")
    suspend fun getUsers(@Query("q") city: String,@Query("units") units: String,@Query("appid") appid: String): Response<MainData>

}