package com.example.wed0518

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wed0518.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val dataSet = arrayListOf("When","I","was","a","young","boy","My","father","took","me","into","a","b","c","d","e","f","g","h","i","j")
//        var adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,dataSet)
        val adapter = MyAdapter(dataSet)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
//        binding.recyclerView.layoutManager = GridLayoutManager(this,2, GridLayoutManager.HORIZONTAL, false)
        binding.recyclerView.adapter = adapter
//        binding.recyclerView.addItemDecoration(DividerItemDecoration(this,LinearLayoutManager.VERTICAL))
        binding.addBtn.setOnClickListener {
            adapter.addItem(binding.editTxt.text.toString())
        }
    }
}