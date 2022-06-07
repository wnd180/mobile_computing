package com.example.pdiary

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.widget.Toast
import java.io.ByteArrayOutputStream


class MemoActivity {
    private val helper = SQLiteHelper(this,"memo",3)

    private fun drawableToByteArray(drawable: Drawable?): ByteArray? {
        val bitmapDrawable = drawable as BitmapDrawable?
        val bitmap = bitmapDrawable?.bitmap
        val stream = ByteArrayOutputStream()
        bitmap?.compress(Bitmap.CompressFormat.PNG, 100, stream)
        val byteArray = stream.toByteArray()

        return byteArray
    }

    private fun saveMemo(){
        val image = imageView.drawable
        val memo = Memo(null,drawableToByteArray(image))
        helper.insertMemo(memo)

        Toast.makeText(this, "저장되었습니다.", Toast.LENGTH_SHORT).show()
        finish()
    }

    private fun updateMemo() {
        val image = imageView.drawble
        val no = intent.get
    }

}