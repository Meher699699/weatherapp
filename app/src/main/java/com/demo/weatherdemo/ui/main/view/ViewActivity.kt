package com.demo.weatherdemo.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.widget.AppCompatTextView
import com.demo.weatherdemo.R
import com.demo.weatherdemo.data.model.ListData
import kotlin.math.roundToInt

class ViewActivity : AppCompatActivity() {
    lateinit var tempTxt: AppCompatTextView
    lateinit var feelLike: AppCompatTextView
    lateinit var clouds: AppCompatTextView
    lateinit var cloudType: AppCompatTextView
    var city:String=""
    var temp:String=""
    var feel:String=""
    var clear:String=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)
        initUi()
    }
    fun initUi(){
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        city= intent.getStringExtra("city").toString()
        temp= intent.getDoubleExtra("temp",0.0).roundToInt().toString()
        feel= intent.getDoubleExtra("feel",0.0).roundToInt().toString()
        clear= intent.getStringExtra("clear").toString()
        supportActionBar?.title=city
        tempTxt=findViewById(R.id.temp)
        feelLike=findViewById(R.id.feelLike)
        clouds=findViewById(R.id.clouds)
        cloudType=findViewById(R.id.cloudType)
        tempTxt.text=temp
        feelLike.text="Feels Like: $feel"
        cloudType.text=clear
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}