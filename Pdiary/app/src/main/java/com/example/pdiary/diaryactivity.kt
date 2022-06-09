package com.example.pdiary

import android.R
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pdiary.databinding.DiaryviewBinding
import java.io.File
import java.io.IOException


class diaryactivity : AppCompatActivity() {
    lateinit var binding: DiaryviewBinding
    var recievedMessage : String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DiaryviewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recievedMessage = intent.getStringExtra("message")
        val fName = recievedMessage.toString()+".txt"
        binding.ddate.text = "날짜 : "+recievedMessage.toString().substring(0,4)+"년 "+
                recievedMessage.toString().substring(4,6)+"월 " +
                recievedMessage.toString().substring(6,8)+"일"
        var str = readDiary(fName)
        binding.dtext.setText(str)
        val imgFile = File("/storage/emulated/0/Pictures/Pdiary/"+recievedMessage.toString()+".png")
        if (imgFile.exists()) {
            val myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath())
            binding.dimage.setImageBitmap(myBitmap)
        }
    }
    fun readDiary(fName: String) :String?{
        var diaryStr : String? = null
        try {
            openFileInput(fName).bufferedReader().forEachLine {
                if (diaryStr == null) {
                    diaryStr = it
                } else {
                    diaryStr += "\n" + it
                }
            }
            Toast.makeText(this,"불러오기 성공",Toast.LENGTH_SHORT).show()
        }catch (e : IOException){
            binding.dtext.text = "불러오기 실패"
        }
        return diaryStr
    }
}