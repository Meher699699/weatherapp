package com.demo.weatherdemo.utils

import android.content.Context
import com.demo.weatherdemo.data.model.ListData

interface OnClick {
    fun onClick (context: Context, listData:ListData)
}