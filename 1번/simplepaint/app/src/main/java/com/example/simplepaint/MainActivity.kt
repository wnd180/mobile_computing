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
import java.lang.reflect.Type

class MainActivity : AppCompatActivity() {

    companion object {
        const val LINE = 1
        const val CIRCLE = 2
        const val Rect = 3
        var curShape = LINE
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(SimplePainter(this))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu?.add(0,1,0,"Draw Line")
        menu?.add(0,2,0,"Draw Circle")
        menu?.add(0,3,0,"Draw Rectangle")
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            1->{
                curShape = LINE
                return true
            }
            2->{
                curShape = CIRCLE
                return true
            }
            3->{
                curShape = Rect
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

    class MyShape ( shapeType: Int, startX:Float, startY:Float, stopX:Float, stopY:Float){
        var shapeType:Int= 0
        var startX:Float = 0f
        var startY:Float = 0f
        var stopX:Float = 0f
        var stopY:Float = 0f
        init {
            this.shapeType = shapeType
            this.startX = startX
            this.startY = startY
            this.stopX = stopX
            this.stopY = stopY
        }

    }
    class SimplePainter(context: Context) : View(context){
        var myshape:ArrayList<MyShape> = ArrayList()
        var startX = -1f
        var startY = -1f
        var stopX = -1f
        var stopY = -1f
        val paint = Paint()
        override fun onTouchEvent(event: MotionEvent?): Boolean {
            when(event!!.action){
                MotionEvent.ACTION_DOWN ->{
                    startX = event.x
                    startY = event.y
                }
                MotionEvent.ACTION_MOVE -> {
                    stopX = event.x
                    stopY = event.y
                    this.invalidate()
                }
               MotionEvent.ACTION_UP -> {
                   stopX = event.x
                   stopY = event.y
                   myshape.add(MyShape(curShape,startX,startY,stopX,stopY))
                    this.invalidate()
                }
            }

            return true
        }

        override fun onDraw(canvas: Canvas?) {
            super.onDraw(canvas)
            paint.isAntiAlias = true
            paint.strokeWidth = 5f
            paint.style = Paint.Style.STROKE
            paint.color = Color.RED

            for (i in myshape.indices){
                when(myshape[i].shapeType){
                    LINE ->{
                        canvas!!.drawLine(myshape[i].startX,myshape[i].startY,myshape[i].stopX,myshape[i].stopY,paint)
                    }
                    CIRCLE ->{
                        val radius = Math.sqrt(Math.pow((myshape[i].stopX-myshape[i].startX).toDouble(),2.0) +
                                Math.pow((myshape[i].stopY-myshape[i].startY).toDouble(),2.0))
                        canvas?.drawCircle(myshape[i].startX,myshape[i].startY,radius.toFloat(),paint)
                    }
                    Rect -> {
                        canvas?.drawRect(myshape[i].startX,myshape[i].startY,myshape[i].stopX,myshape[i].stopY,paint)
                    }
                }
            }
            when(curShape){
                LINE ->{
                    canvas?.drawLine(startX,startY,stopX,stopY,paint)
                }
                CIRCLE ->{
                    val radius = Math.sqrt(Math.pow((stopX-startX).toDouble(),2.0) +
                    Math.pow((stopY-startY).toDouble(),2.0))
                    canvas?.drawCircle(startX,startY,radius.toFloat(),paint)
                }
                Rect -> {
                    canvas?.drawRect(startX,startY,stopX,stopY,paint)
                }
            }


        }
    }

}

