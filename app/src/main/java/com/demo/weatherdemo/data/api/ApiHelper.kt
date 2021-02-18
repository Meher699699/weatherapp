package com.demo.weatherdemo.data.api

import com.demo.weatherdemo.data.model.MainData
import retrofit2.Response

interface ApiHelper {
    suspend fun getUsers(Str1:String,Str2: String,Str3: String): Response<MainData>

}