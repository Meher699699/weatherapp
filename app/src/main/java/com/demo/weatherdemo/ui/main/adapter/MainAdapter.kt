package com.demo.weatherdemo.ui.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.demo.weatherdemo.R
import com.demo.weatherdemo.data.model.ListData
import com.demo.weatherdemo.utils.OnClick
import kotlin.math.roundToInt

class MainAdapter(private val users: ArrayList<ListData>, var context: Context,onclick:OnClick) : RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    private lateinit var onclick: OnClick
    init {
        this.onclick=onclick
    }

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(user: ListData, context: Context,onclick: OnClick) {
            val tempTxt: AppCompatTextView = itemView.findViewById(R.id.temp)
            val cloudy: AppCompatTextView = itemView.findViewById(R.id.cloudy)
            val rain: AppCompatTextView = itemView.findViewById(R.id.rain)
            val container: LinearLayout = itemView.findViewById(R.id.container)
            tempTxt.text = "Temp:"+user.main.temp.roundToInt().toString()
            cloudy.text = "Temp:"+user.main.temp_max.roundToInt().toString()
            rain.text = "Temp:"+user.main.humidity.toString()

            container.setOnClickListener {
                onclick.onClick(context,user)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            DataViewHolder(
                    LayoutInflater.from(parent.context).inflate(
                            R.layout.item_layout, parent,
                            false
                    )
            )

    override fun onBindViewHolder(holder: MainAdapter.DataViewHolder, position: Int) =
            holder.bind(users[position], context,onclick)

    override fun getItemCount(): Int = users.size

    fun addData(list: List<ListData>) {
        users.addAll(list)
    }

}