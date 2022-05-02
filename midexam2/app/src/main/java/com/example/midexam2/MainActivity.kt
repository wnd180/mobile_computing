package com.example.midexam2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.midexam2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding :ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.start.setOnClickListener{binding.timer.start()}
        binding.stop.setOnClickListener{binding.timer.stop()}

    }
}