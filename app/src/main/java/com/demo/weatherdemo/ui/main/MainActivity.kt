package com.demo.weatherdemo.ui.main

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.demo.weatherdemo.R
import com.demo.weatherdemo.ui.main.view.WeatherActivity

class MainActivity : AppCompatActivity() {
    lateinit var button: TextView
    lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.btnTxt) as TextView
        editText = findViewById(R.id.editTextCity) as EditText
        button.setOnClickListener {
            startActivity()
        }
    }

    fun startActivity() {
        if (editText.text.toString().equals("")) {
            Toast.makeText(this, "PLease Enter City", Toast.LENGTH_SHORT).show()
        } else {
            val intent =
                Intent(this, WeatherActivity::class.java).apply {
                    putExtra(
                        "city",
                        editText.text.toString().trim()
                    )
                }
            startActivity(intent)

        }

    }
}