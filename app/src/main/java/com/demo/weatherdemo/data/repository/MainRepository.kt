package com.demo.weatherdemo.data.repository

import com.demo.weatherdemo.data.api.ApiHelper
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiHelper: ApiHelper) {
    suspend fun getUsers(string1: String,string2: String,string3: String) = apiHelper.getUsers(string1,string2,string3)
}