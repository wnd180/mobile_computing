package com.example.pdiary

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pdiary.databinding.DiaryviewBinding

class diaryactivity : AppCompatActivity() {
    lateinit var binding: DiaryviewBinding
    var recievedMessage : String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DiaryviewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recievedMessage = intent.getStringExtra("message")
    }
}