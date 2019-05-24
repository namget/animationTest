package com.namget.customline.circleview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.animation.Animation

//QUEUE 를 통해 바뀔값을 구현중이였으나 2초마다 서버에서 받아오는값을 뿌려주면 되므로 삭제
class Circle(context: Context, attrs: AttributeSet) : View(context, attrs) {

    private val paint: Paint
    private val rect: RectF
    private var changedValue = 240f
    private var animation: CircleAngleAnimation = CircleAngleAnimation(this, changedValue).apply {
        duration = 1000
        this.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(animation: Animation?) {}
            override fun onAnimationStart(animation: Animation?) {
                Log.e("test", "animationStart")
            }

            override fun onAnimationEnd(animation: Animation?) {
                Log.e("test", "animationEnd")
            }
        })
    }


    companion object {
        private val START_ANGLE_POINT = -90.0f
    }

    //Initial Angle (optional, it can be zero)
    var angle: Float = 0f

    init {
        val strokeWidth = 40.0f
        paint = Paint()
        paint.isAntiAlias = true
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = strokeWidth
        //Circle color
        paint.color = Color.RED
        //size 200x200 example
        rect = RectF(
            strokeWidth,
            strokeWidth,
            (200 + strokeWidth),
            (200 + strokeWidth)
        )
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawArc(rect, START_ANGLE_POINT, angle, false, paint)
    }

    fun changeValue(score: Int) {
        animation.changeValue(scoreToAngle(score))
        this.startAnimation(animation)
    }

    /**
     *  1점당 3.6점
     */
    fun scoreToAngle(score: Int): Float {
        return score * 3.6f
    }


}