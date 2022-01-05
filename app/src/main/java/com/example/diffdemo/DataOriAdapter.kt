package com.example.diffdemo

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DataOriAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val dataList = arrayListOf<Data>()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(datas: List<Data>) {
        dataList.clear()
        dataList.addAll(datas)
        
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.data_item_layout, parent, false)
        return DataItem(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as DataItem).bind(dataList[position])
    }

    override fun getItemCount(): Int = dataList.size

    inner class DataItem(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(data: Data) {
            val title = view.findViewById<TextView>(R.id.title)
            title.text = data.title
        }
    }
}