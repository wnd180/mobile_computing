package com.example.week2_homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var idButton: Button;
    lateinit var nameButton: Button;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        idButton = findViewById<Button>(R.id.idButton)
        nameButton = findViewById<Button>(R.id.nameButton)
        idButton.setOnClickListener{
            Toast.makeText(applicationContext, "60201901", Toast.LENGTH_LONG).show()
        }
        nameButton.setOnClickListener{
            Toast.makeText(applicationContext, "권성중", Toast.LENGTH_LONG).show()
        }
    }

}