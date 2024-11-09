package com.example.secondandroidlab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.secondandroidlab.adapter.ItemAdapter
import com.example.secondandroidlab.model.generateRecyclerViewItems

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val items = generateRecyclerViewItems(20)

        val adapter = ItemAdapter(items)
        recyclerView.adapter = adapter
    }
}