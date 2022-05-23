package com.example.simplepaint

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.drawable.shapes.RectShape
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.MotionEvent
import android.view.View
import com.example.myapplication.R
import java.lang.reflect.Type

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(SimplePainter(this))
    }


}
class SimplePainter(context: Context) : View(context) {
    var startX = -1f
    var startY = -1f
    var stopX = -1f
    var stopY = -1f
    val paint = Paint()
    fun onDraw(canvas: Canvas?) {
        val paint = Paint()
        paint.isAntiAlias = true
        paint.strokeWidth = 5f
        paint.style = Paint.Style.STROKE
        paint.color = Color.RED

        if (canvas != null) {
            canvas.drawCircle(300f,300f,10f,paint )
        }
    }
}



