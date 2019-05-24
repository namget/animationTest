package com.namget.customline.circleview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.namget.customline.R
import kotlinx.android.synthetic.main.activity_circle.*

class CircleActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_circle)
        init()
    }


    fun init() {
        val circle: Circle = myCircle
        circle.changeValue(0)
        circle.changeValue(90)
    }
}