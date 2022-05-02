package com.example.myapplication


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Toast
import android.view.Menu
import android.view.MenuItem
import com.example.myapplication.databinding.FragmentlayoutBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: FragmentlayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentlayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        binding.button1.setOnClickListener{
            Toast.makeText(this,"click",Toast.LENGTH_LONG).show()
            supportFragmentManager.beginTransaction()
            .replace(binding.fragView.id,Examplefragment())
            .commit()}
        binding.button2.setOnClickListener{
            Toast.makeText(this,"click",Toast.LENGTH_LONG).show()
            supportFragmentManager.beginTransaction()
            .replace(binding.fragView.id,ExamplefragmentTwo())
            .commit()}
        binding.button3.setOnClickListener{
            Toast.makeText(this,"click",Toast.LENGTH_LONG).show()
            supportFragmentManager.beginTransaction()
            .replace(binding.fragView.id,Examplefragmentthree())
            .commit()}

    }
}