package com.namget.customline

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.MeasureSpec
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_gradient.*


class GradationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gradient)
        getDisplayMetrics()
        gradientView()
    }


    fun getDisplayMetrics() {
        val dm = applicationContext.resources.displayMetrics
        val width = dm.widthPixels
        println("width : $width")
        val height = dm.heightPixels
        println("height : $height")
    }


    fun gradientView() {

        val linearLayout = myLinearLayout
        linearLayout.measure(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED)
        val observer = linearLayout.viewTreeObserver
        observer.addOnGlobalLayoutListener {
            Log.d("Log", "Height: " + linearLayout.height)
            Log.d("Log", "Width: " + linearLayout.width)
        }

        val red: View = View(this).apply {
            layoutParams = ViewGroup.LayoutParams(100, LinearLayout.LayoutParams.MATCH_PARENT)
            background = ContextCompat.getDrawable(this@GradationActivity, android.R.color.holo_red_light)
        }
        val yellow: View = View(this).apply {
            layoutParams = ViewGroup.LayoutParams(100, LinearLayout.LayoutParams.MATCH_PARENT)
            background = ContextCompat.getDrawable(this@GradationActivity, android.R.color.holo_orange_light)
        }
        val green: View = View(this).apply {
            layoutParams = ViewGroup.LayoutParams(100, LinearLayout.LayoutParams.MATCH_PARENT)
            background = ContextCompat.getDrawable(this@GradationActivity, android.R.color.holo_green_light)
        }
        val blue: View = View(this).apply {
            layoutParams = ViewGroup.LayoutParams(100, LinearLayout.LayoutParams.MATCH_PARENT)
            background = ContextCompat.getDrawable(this@GradationActivity, android.R.color.holo_blue_light)
        }
        val white: View = View(this).apply {
            layoutParams = ViewGroup.LayoutParams(100, LinearLayout.LayoutParams.MATCH_PARENT)
            background = ContextCompat.getDrawable(this@GradationActivity, android.R.color.white)
        }

        myLinearLayout.addView(red)
        myLinearLayout.addView(yellow)
        myLinearLayout.addView(white)
        myLinearLayout.addView(green)
        myLinearLayout.addView(blue)
    }

}