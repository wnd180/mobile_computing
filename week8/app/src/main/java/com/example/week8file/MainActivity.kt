package com.example.week8file

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.week8file.databinding.ActivityMainBinding
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.btnRead.setOnClickListener{
            try {
                var inFs : FileInputStream = openFileInput("file.txt")
                var txt = ByteArray(30)
                inFs.read(txt)
                var str = txt.toString(Charsets.UTF_8)
                Toast.makeText(applicationContext,str,Toast.LENGTH_SHORT).show()
                inFs.close()
            }catch (e:IOException){
                Toast.makeText(applicationContext,"파일 없음",Toast.LENGTH_SHORT).show()
            }
        }
        binding.btnWrite.setOnClickListener{
            var outFs : FileOutputStream = openFileOutput("file.txt",Context.MODE_PRIVATE)
            var str = "얄미운 나비"
            outFs.write(str.toByteArray())
            outFs.close()
            Toast.makeText(applicationContext,"file.txt 생성",Toast.LENGTH_SHORT).show()
        }
    }
}