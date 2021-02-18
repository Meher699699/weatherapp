package com.demo.weatherdemo.data.model

import com.google.gson.annotations.SerializedName

data class ListData(
    @SerializedName("dt") val dt : Double,
    @SerializedName("main") val main : Main,
    @SerializedName("weather") val weather : List<Weather>,
    @SerializedName("clouds") val clouds : Clouds,
    @SerializedName("wind") val wind : Wind,
    @SerializedName("visibility") val visibility : Double,
    @SerializedName("pop") val pop : Double,
    @SerializedName("sys") val sys : Sys,
    @SerializedName("dt_txt") val dt_txt : String
)
