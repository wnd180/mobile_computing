package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.calculator.databinding.ActivityMainBinding
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        var num1:Int
        var num2: Int
        var result:Int
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.add.setOnClickListener{
            try {
                num1 = binding.num1.text.toString().toInt()
                num2 = binding.num2.text.toString().toInt()
                result = num1 + num2
                binding.result.text = getString(R.string.results,result.toString())
            }catch (e: Exception){
                Toast.makeText(applicationContext,"값을 넣어주세요.",Toast.LENGTH_LONG).show()
            }
        }

        binding.add.setOnClickListener{
            try{
                num1 = binding.num1.text.toString().toInt()
                num2 = binding.num2.text.toString().toInt()
                result = num1+num2
                binding.result.text = getString(R.string.results,result.toString())
            }catch (e: Exception){
                Toast.makeText(applicationContext,"값을 넣어주세요.",Toast.LENGTH_LONG).show()
            }
        }

        binding.sub.setOnClickListener{
            try {
                num1 = binding.num1.text.toString().toInt()
                num2 = binding.num2.text.toString().toInt()
                result = num1-num2
                binding.result.text = getString(R.string.results,result.toString())
            }catch (e: Exception){
                Toast.makeText(applicationContext,"값을 넣어주세요.",Toast.LENGTH_LONG).show()
            }
        }

        binding.mul.setOnClickListener{
            try {
                num1 = binding.num1.text.toString().toInt()
                num2 = binding.num2.text.toString().toInt()
                result=num1*num2
                binding.result.text = getString(R.string.results,result.toString())
            }catch (e: Exception){
                Toast.makeText(applicationContext,"값을 넣어주세요.",Toast.LENGTH_LONG).show()
            }
        }

        binding.div.setOnClickListener{
            try {
                num1 = binding.num1.text.toString().toInt()
                num2 = binding.num2.text.toString().toInt()
                try {
                    result=num1/num2
                    binding.result.text = getString(R.string.results,result.toString())
                }catch (e: Exception){
                    Toast.makeText(applicationContext,"0으로 나눌 수 없습니다.",Toast.LENGTH_LONG).show()
                }
            }catch (e: Exception){
                Toast.makeText(applicationContext,"값을 넣어주세요.",Toast.LENGTH_LONG).show()
            }
        }
    }
}