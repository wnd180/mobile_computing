package com.example.mid_exam

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import com.example.mid_exam.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var num1 : Double
        var num2 : Double
        var result : Double
        binding.B0.setOnClickListener(this)
        binding.B1.setOnClickListener(this)
        binding.B2.setOnClickListener(this)
        binding.B3.setOnClickListener(this)
        binding.B4.setOnClickListener(this)
        binding.B5.setOnClickListener(this)
        binding.B6.setOnClickListener(this)
        binding.B7.setOnClickListener(this)
        binding.B8.setOnClickListener(this)
        binding.B9.setOnClickListener(this)
        binding.Bdot.setOnClickListener{
            var dot : String
            dot = "."
            if(binding.num1.isFocused){
                num1 = binding.num1.text.toString() + dot
            }
            else if(binding.num2.isFocused) {
                num2 = binding.num2.text.toString() + dot
            }
        }
        binding.add.setOnClickListener{
            num1 = binding.num1.text.toString().toDouble()
            num2 = binding.num1.text.toString().toDouble()
            result = num1 + num2
            binding.result.text = getString(R.string.results, result.toString())
        }
        binding.sub.setOnClickListener{
            num1 = binding.num1.text.toString().toDouble()
            num2 = binding.num1.text.toString().toDouble()
            result = num1 - num2
            binding.result.text = getString(R.string.results, result.toString())
        }
        binding.mul.setOnClickListener{
            num1 = binding.num1.text.toString().toDouble()
            num2 = binding.num1.text.toString().toDouble()
            result = num1 * num2
            binding.result.text = getString(R.string.results, result.toString())
        }
        binding.div.setOnClickListener{
            num1 = binding.num1.text.toString().toDouble()
            num2 = binding.num1.text.toString().toDouble()
            result = num1 / num2
            binding.result.text = getString(R.string.results, result.toString())
        }
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        if(currentFocus != null){
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        }
        return super.dispatchTouchEvent(ev)
    }
    override fun onClick(v: View?){
        var input:String = (v as Button).text.toString()
        if(binding.num1.isFocused){
            input = binding.num1.text.toString() + input
            binding.num1.setText(input)
        }
        else if(binding.num2.isFocused) {
            binding.num2.text.toString() + input
            binding.num2.setText(input)
        }
    }

}

