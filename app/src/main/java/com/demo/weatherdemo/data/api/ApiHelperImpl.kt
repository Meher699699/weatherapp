package com.demo.weatherdemo.data.api

import com.demo.weatherdemo.data.model.MainData
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val  apiService: ApiService):ApiHelper {
    override suspend fun getUsers(string1: String,string2: String,string3: String): Response<MainData> =apiService.getUsers(string1,string2,string3)

}