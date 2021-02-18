package com.demo.weatherdemo.data.model

import com.google.gson.annotations.SerializedName

data class MainData(
    @SerializedName("cod") val cod : Int,
    @SerializedName("message") val message : Int,
    @SerializedName("cnt") val cnt : Int,
    @SerializedName("list") val list : List<ListData>,
    @SerializedName("city") val city : City
)
