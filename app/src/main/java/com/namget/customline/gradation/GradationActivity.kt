package com.namget.customline.gradation

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.MeasureSpec
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.namget.customline.R
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

        val linearLayout = myLinearLayout.apply {
            measure(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED)
            clipToOutline= true
        }

        val observer = linearLayout.viewTreeObserver
        observer.addOnGlobalLayoutListener {
            Log.d("Log", "Height: " + linearLayout.height)
            Log.d("Log", "Width: " + linearLayout.width)
        }

        val red: View = View(this).apply {
            layoutParams = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT).apply {
                weight = 0.1f
            }
            background = ContextCompat.getDrawable(this@GradationActivity, android.R.color.holo_red_light)
        }
        val yellow: View = View(this).apply {
            layoutParams = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT).apply {
                weight = 0.1f
            }
            background = ContextCompat.getDrawable(this@GradationActivity, android.R.color.holo_orange_light)
        }
        val green: View = View(this).apply {
            layoutParams = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT).apply {
                weight = 0.1f
            }
            background = ContextCompat.getDrawable(this@GradationActivity, android.R.color.holo_green_light)
        }
        val blue: View = View(this).apply {
            layoutParams = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT).apply {
                weight = 0.1f
            }
            background = ContextCompat.getDrawable(this@GradationActivity, android.R.color.holo_blue_light)
        }
        val white: View = View(this).apply {
            layoutParams = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT).apply {
                weight = 0.1f
            }
            background = ContextCompat.getDrawable(this@GradationActivity, android.R.color.white)
        }

        myLinearLayout.addView(red)
        myLinearLayout.addView(yellow)
        myLinearLayout.addView(white)
        myLinearLayout.addView(green)
        myLinearLayout.addView(blue)
    }

}