package com.example.pdiary

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.pdiary.databinding.ActivityMainBinding
import java.io.File
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var recievedMessage : String? = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "그림 일기장"
        recievedMessage = intent.getStringExtra("message")
        binding.inputDate.text = "선택한 날짜 : "+ recievedMessage.toString().substring(0,4)+"년 "+
                recievedMessage.toString().substring(4,6)+"월 "+
                recievedMessage.toString().substring(6,8)+"일"
        initSignaturePad()
    }

    private fun initSignaturePad() {
        /** 초기화 */
        binding.bClear.setOnClickListener {
            binding.signaturePad.clearCanvas()
        }

        /** 저장 */
        binding.bSave.setOnClickListener {
            var str = binding.inputText.text.toString().trim()
            if (!binding.signaturePad.isBitmapEmpty) {
                /** 권한 체크 */
                if (!checkPermission(Manifest.permission.READ_EXTERNAL_STORAGE) || !checkPermission(
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                    )
                ) {
                    return@setOnClickListener
                }

                /** 그림 저장 */
                if (!imageExternalSave(binding.signaturePad.signatureBitmap, this.getString(R.string.app_name))) {
                    Toast.makeText(this, "그림 일기장 저장을 실패하였습니다", Toast.LENGTH_SHORT).show()
                } else if (str != "") {
                    openFileOutput(recievedMessage+".txt",Context.MODE_PRIVATE).use {
                        it.write(str.toByteArray())
                    }
                    Toast.makeText(this, "그림 일기장을 저장하였습니다.", Toast.LENGTH_SHORT).show()
                    val myIntent = Intent(this,listdiary::class.java)
                    startActivity(myIntent)
                }else{
                    Toast.makeText(this,"글씨가 비어있습니다.",Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(this, "그림이 비어있습니다.", Toast.LENGTH_SHORT).show()
            }
        }
    }
    /** 다이어리 텍스트 저장*/
//    fun readDiary(fName: String) : String?{
//        var diaryStr : String? = null
//        try {
//            openFileInput(fName).bufferedReader().forEachLine {
//                if(diaryStr==null){diaryStr=it}
//                else{diaryStr += "\n"+it}
//                Log.d("TAG",diaryStr!!)
//
//        }
//    }

    /** 이미지 저장 */
    private fun imageExternalSave(bitmap: Bitmap, path: String): Boolean {
        val state = Environment.getExternalStorageState()
        if (Environment.MEDIA_MOUNTED == state) {

            val rootPath =
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
                    .toString()
            val dirName = "/" + path
            val fileName = recievedMessage + ".png"
            val savePath = File(rootPath + dirName)
            savePath.mkdirs()

            val file = File(savePath, fileName)
            if (file.exists()) file.delete()

            try {
                val out = FileOutputStream(file)
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, out)
                out.flush()
                out.close()

                //갤러리 갱신
                galleyAddPic(file)
                return true
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return false
    }

    /** 갤러리 갱신 */
    private fun galleyAddPic(file: File) {
        Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE).also { mediaScanIntent ->
            mediaScanIntent.data = Uri.fromFile(file)
            sendBroadcast(mediaScanIntent)
        }
    }

    /** 권한 체크 */
    private fun checkPermission(permission: String): Boolean {
        val permissionChecker = ContextCompat.checkSelfPermission(applicationContext, permission)

        //권한이 없으면 권한 요청
        if (permissionChecker == PackageManager.PERMISSION_GRANTED) {
            return true
        }

        ActivityCompat.requestPermissions(this, arrayOf(permission), 100)
        return false
    }
}

