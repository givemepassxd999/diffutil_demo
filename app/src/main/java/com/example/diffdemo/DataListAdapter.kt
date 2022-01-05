package com.example.diffdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class DataListAdapter : ListAdapter<Data, RecyclerView.ViewHolder>(DiffItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.data_item_layout, parent, false)
        return DataItem(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as DataItem).bind(getItem(position))
    }

    override fun getItemCount(): Int = currentList.size

    inner class DataItem(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(data: Data) {
            val title = view.findViewById<TextView>(R.id.title)
            title.text = data.title
        }
    }

    private class DiffItemCallback : DiffUtil.ItemCallback<Data>() {
        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem.title == newItem.title
        }
    }
}