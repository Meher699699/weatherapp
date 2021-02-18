package com.demo.weatherdemo.ui.main.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.demo.weatherdemo.R
import com.demo.weatherdemo.data.model.ListData
import com.demo.weatherdemo.ui.main.adapter.MainAdapter
import com.demo.weatherdemo.ui.main.viewmodel.MainViewModel
import com.demo.weatherdemo.utils.OnClick
import com.demo.weatherdemo.utils.Status
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeatherActivity : AppCompatActivity(), OnClick {
    private val mainViewModel: MainViewModel by viewModels()
    lateinit var recyclerView: RecyclerView
    lateinit var mainAdapter: MainAdapter
    lateinit var progressBar: ProgressBar
    var city: String = ""
    lateinit var onClick: OnClick
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)
        city = intent.getStringExtra("city").toString().substring(0, 1)
            .toUpperCase() + intent.getStringExtra("city").toString().substring(1).toLowerCase()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = city
        progressBar = findViewById(R.id.progressBar)
        onClick = this
        setupObserver()
        setupUIPlayNow()

    }

    private fun setupUIPlayNow() {
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        mainAdapter = MainAdapter(arrayListOf(), this, onClick)
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                (recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )


        recyclerView.adapter = mainAdapter
    }

    fun setupObserver() {
        mainViewModel.fetchData(city)
        mainViewModel.users.observe(this, Observer {
            it.status
            when (it.status) {
                Status.SUCCESS -> {
                    progressBar.visibility = View.GONE
                    it.data?.let { users -> renderList(it.data.list) }
                    recyclerView.visibility = View.VISIBLE
                }
                Status.LOADING -> {
                    progressBar.visibility = View.VISIBLE
                    recyclerView.visibility = View.GONE
                }
                Status.ERROR -> {
                    //Handle Error
                    progressBar.visibility = View.GONE
                    Toast.makeText(this, it.data!!.message, Toast.LENGTH_LONG).show()


                }
            }
        })
    }

    private fun renderList(users: List<ListData>) {
        mainAdapter.addData(users)
        mainAdapter.notifyDataSetChanged()
    }

    override fun onClick(context: Context, listData: ListData) {
        val intent =
            Intent(this, ViewActivity::class.java).apply {

                putExtra("city", city)
                    .putExtra("temp", listData.main.temp)
                    .putExtra("feel", listData.main.feels_like)
                    .putExtra("cloud", listData.weather[0].main)
                    .putExtra("clear", listData.weather[0].description)
            }
        startActivity(intent)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}