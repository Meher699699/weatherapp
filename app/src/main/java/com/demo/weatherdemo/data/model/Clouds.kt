package com.demo.weatherdemo.data.model

import com.google.gson.annotations.SerializedName

data class Clouds(
    @SerializedName("all") val all : Int
)
