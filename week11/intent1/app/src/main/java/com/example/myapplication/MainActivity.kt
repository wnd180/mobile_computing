package com.example.myapplication

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d("MYTAG","onCreate")

        val reqLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()){ result: ActivityResult ->
            if(result.resultCode == RESULT_OK){
                Log.d("TAG","return")
                val intent = result.data
                val clickedBtn : String? = intent?.getStringExtra("res")
                "btn: $clickedBtn".also { binding.txtMainView1.text = it }
            }
        }

        binding.btnSub.setOnClickListener{
            val intent:Intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:114")).apply {
                putExtra("next","level")
            }
            Log.d("MYTAG","btnclicked")
            intent.putExtra("num",30)
            intent.putExtra("edit",binding.editTxt.text.toString())
            try {
                startActivity(intent)
            }
            catch (e: ActivityNotFoundException){
                Toast.makeText(applicationContext,"No app for action",Toast.LENGTH_SHORT).show()
            }
        //startActivity(intent)
        }

    }
    override fun onSupportNavigateUp(): Boolean {
        setResult(RESULT_OK,intent)
        finish()
        return true
    }

    override fun onStart() {
        super.onStart()
        Log.d("MYTAG","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MYTAG","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MYTAG","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MYTAG", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MYTAG","onDestroy")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d("MYTAG","onSaveInstance")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
        Log.d("MYTAG","onRestoreInstance")
    }
}