package com.example.wed0518

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wed0518.databinding.ListItemBinding

class MyAdapter(private val dataSet: ArrayList<String>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    class MyViewHolder(val binding : ListItemBinding, var counter:Int) : RecyclerView.ViewHolder(binding.root)
    override fun getItemCount() = dataSet.size
    var count = 0
//    val adapter = MyAdapter(dataSet)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        count ++
        Log.d("TAG","Viewholder Num: $count")
        return MyViewHolder(ListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false),count)
//        return MyViewHolder(ListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    }

    fun addItem(item : String){
        dataSet.add(item)
//        this.notifyDataSetChanged()
        this.notifyItemInserted(dataSet.size-1)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val binding = (holder).binding
        binding.itemText.text = dataSet[position]
        binding.itemRoot.setOnClickListener {
//            Log.d("TAG","position $position clicked")
            Log.d("TAG","position $position counter ${holder.counter} clicked")
        }
        binding.itemRoot.setOnLongClickListener {
            Log.d("TAG","position $position long clicked")
            dataSet.removeAt(position)
//            this.notifyDataSetChanged()
            this.notifyItemRemoved(position)
            this.notifyItemRangeChanged(position,dataSet.size-position)
            true
        }
    }

}

