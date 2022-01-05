package com.example.diffdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.list)
        val manager = LinearLayoutManager(this)
        recyclerView.layoutManager = manager
        val adapter = DataListAdapter()
        recyclerView.adapter = adapter
        val list = arrayListOf<Data>()
        for (i in 0..100) {
            val data = Data()
            data.id = i
            data.title = "number $i"
            list.add(data)
        }
        adapter.submitList(list)
    }
}