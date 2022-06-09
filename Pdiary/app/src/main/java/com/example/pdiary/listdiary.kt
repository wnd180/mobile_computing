package com.example.pdiary

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pdiary.databinding.DiarylistBinding
import java.util.*

class listdiary : AppCompatActivity() {
    lateinit var binding: DiarylistBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DiarylistBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var putmsg = ""

        val today = Calendar.getInstance()
        binding.datePicker.init(today.get(Calendar.YEAR), today.get(Calendar.MONTH),
            today.get(Calendar.DAY_OF_MONTH)

        ) { view, year, month, day ->
            var month = month + 1
            var mmonth: String = month.toString()
            var mday : String = day.toString()
            if (month<10){
                mmonth = "0$month"
            }
            if (day<10){
                mday = "0$day"
            }
            putmsg = "$year$mmonth$mday"
            val msg = "$year/$mmonth/$mday 를 선택했습니다."

            Toast.makeText(this@listdiary, msg, Toast.LENGTH_SHORT).show()
        }
        binding.addBtn.setOnClickListener {
            // 우선 들고갈 메시지 변수에 담기
            val inputMsg = putmsg

            // 이동할 액티비티 경로 잡기
            val myIntent = Intent(this, MainActivity::class.java)

            // 가지고 갈 메시지를 putExtra에 담기
            myIntent.putExtra("message", inputMsg)
            startActivity(myIntent)
        }

        binding.seeBtn.setOnClickListener {
            // 우선 들고갈 메시지 변수에 담기
            val inputMsg = putmsg

            // 이동할 액티비티 경로 잡기
            val myIntent = Intent(this, diaryactivity::class.java)

            // 가지고 갈 메시지를 putExtra에 담기
            myIntent.putExtra("message", inputMsg)
            startActivity(myIntent)
        }

    }

}