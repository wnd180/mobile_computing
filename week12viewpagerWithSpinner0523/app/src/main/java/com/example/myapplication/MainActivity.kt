package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.ActivityViewpager2Binding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val dataSet = arrayOf(
            ImageElement("마라샹궈", R.drawable.item1,"이걸"),
            ImageElement("크로플", R.drawable.item2,"보니까"),
            ImageElement("아인슈페너", R.drawable.item3,"배고프네")
        )
        val imageAdapter = MyAdapter(dataSet)
        binding.mainTxt.text = "무언가"
        binding.viewpager2.adapter = imageAdapter
        ArrayAdapter.createFromResource(
            this, R.array.foods_array,android.R.layout.simple_spinner_item
        ).also { arrayAdapter ->
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.foodsSpinner.adapter = arrayAdapter
        }
        binding.foodsSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, pos: Int, id: Long) {
                binding.viewpager2.currentItem = pos
            }
            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }
    }

}