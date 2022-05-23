package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ActivityViewpager2Binding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityViewpager2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val dataSet = arrayOf("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z")
        val mutableDataSet = dataSet.toMutableSet()
        val adapter = MyAdapter(mutableDataSet)
        binding.viewpager2.adapter = adapter
    }
    override fun onBindViewHolder(holder: MyViewHolder,position:Int){
        val binding = (holder as MyViewHolder).binding
        binding.itemText.text = dataSet[position]
        binding.itemRoot.setOnClickListener {
            Log.d("TAG","position $position counter ${holder.counter} clicked")
        }
    }
//        val dataSet = arrayOf(
//            ImageElement("마라샹궈", R.drawable.item1),
//            ImageElement("크로플", R.drawable.item2),
//            ImageElement("아인슈페너", R.drawable.item3)
//        )
//        binding.mainTxt.text= "무언가"
//        binding.viewpager2.adapter = Myadpater(dataSet)
    }
}