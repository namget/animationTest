package com.namget.customline.circleview

import android.view.animation.Animation
import android.view.animation.Transformation


class CircleAngleAnimation(private val circle: Circle, newAngle: Float) : Animation() {

    private var oldAngle: Float
    private var newAngle: Float


    init {
        this.oldAngle = circle.angle
        this.newAngle = newAngle
    }

    override fun applyTransformation(interpolatedTime: Float, transformation: Transformation) {
        val angle = oldAngle + (newAngle - oldAngle) * interpolatedTime
        circle.angle = angle
        circle.requestLayout()
    }

    fun changeValue(newAngle: Float) {
        this.oldAngle = circle.angle
        this.newAngle = newAngle
    }

}