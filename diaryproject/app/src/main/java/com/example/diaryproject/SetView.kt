package com.example.diaryproject

import android.view.MotionEvent
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;


class SetView(context: Context?) : View(context) {
    private val paint: Paint = Paint()

    //여러가지의 그리기 명령을 모았다가 한번에 출력해주는
    //버퍼역할을 담당
    private val path: Path = Path()
    private var x = 0
    private var y = 0
    protected override fun onDraw(canvas: Canvas) {
        paint.setColor(Color.BLACK)

        //setStyle :
        //FILL              채우기만 하며 외곽선은 그리지 않는다. (디폴트 값)
        //FILL_AND_STROKE   채우기도 하고 외곽선도 그린다.
        //STROKE            채우지는 않고 외곽선만 그린다.
        paint.setStyle(Paint.Style.STROKE)

        //setStrokeWidth : 두께를 설정
        paint.setStrokeWidth(10F)

        //path객체가 가지고 있는 경로를 화면에 그린다
        canvas.drawPath(path, paint)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        x = event.x.toInt()
        y = event.y.toInt()
        when (event.action) {
            MotionEvent.ACTION_DOWN -> path.moveTo(x.toFloat(), y.toFloat())
            MotionEvent.ACTION_MOVE -> {
                x = event.x.toInt()
                y = event.y.toInt()
                path.lineTo(x.toFloat(), y.toFloat())
            }
        }

        //View의 onDraw()를 호출하는 메소드
        invalidate()
        return true
    }
}
