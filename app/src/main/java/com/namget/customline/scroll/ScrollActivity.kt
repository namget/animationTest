package com.namget.customline.scroll

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.namget.customline.R
import com.namget.customline.data.LineData
import com.namget.customline.data.LineItemInterface
import com.namget.customline.data.destinData
import kotlinx.android.synthetic.main.activity_scroll.*
import kotlinx.android.synthetic.main.item_current_dot2.*
import kotlinx.android.synthetic.main.item_destionation_dot.view.*
import kotlinx.android.synthetic.main.item_line.view.*

class ScrollActivity : AppCompatActivity() {

    val lineList: MutableList<LineItemInterface> = arrayListOf()
    var currentPosition = 0
    val MINUS_DISTANCE = 10
    val handler: Handler by lazy {
        Handler()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scroll)
        init()
        initView()
        currentDotAnimate()
    }

    fun init() {
        lineList.add(LineData("", 100))
        lineList.add(destinData("", 90))
        lineList.add(LineData("", 500))
        lineList.add(destinData("", 90))
        lineList.add(LineData("", 500))
        lineList.add(destinData("", 90))
    }

    fun initView() {
        for (i in lineList.reversed()) {
            if (i is LineData)
                scrollNestedLinear.addView(createLineView(i.distance))
            if (i is destinData)
                scrollNestedLinear.addView(destinationView())
        }
        changeLength(currentPosition, MINUS_DISTANCE)
    }

    /**
     * disTanceMinus or leftDistance
     */
    fun changeLength(position: Int, distanceMinus: Int) {
        handler.postDelayed(
            Runnable {
                if (currentPosition < lineList.size) {
                    val data = lineList[position]
                    var distance = data.distance
                    if (distance - distanceMinus >= 0) {
                        distance -= distanceMinus
                        data.distance = distance
                        Log.e("test", "distance ${distance}")
                        val view = scrollNestedLinear.getChildAt(lineList.size - 1 - position)
                        if (data is LineData) {
                            Log.e("test1", "line")
                            view.lineLayout.layoutParams.height = distance
                            view.lineLayout.requestLayout()
                        } else if (data is destinData) {
                            Log.e("test2", "destin")
                            view.itemDestinLayout.layoutParams.height = distance
                            view.itemDestinLayout.requestLayout()
                        }
                    } else {
                        currentPosition++
                    }
                    changeLength(currentPosition, MINUS_DISTANCE)
                }
            }, 1000
        )
    }

    fun createLineView(distance: Int): View = LayoutInflater.from(this).inflate(R.layout.item_line, null).apply {
        layoutParams = ViewGroup.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, distance)
    }


    fun destinationView(): View = LayoutInflater.from(this).inflate(R.layout.item_destionation_dot, null).apply {
        layoutParams =
            ViewGroup.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
    }


    fun currentDotAnimate() {
        val anim = AnimationUtils.loadAnimation(this, R.anim.scale_anim).apply {
            repeatCount = Animation.INFINITE
            repeatMode = Animation.REVERSE
        }
        val anim2 = AnimationUtils.loadAnimation(this, R.anim.scale_anim2).apply {
            repeatCount = Animation.INFINITE
            repeatMode = Animation.REVERSE
        }
        currentDot2.startAnimation(anim)
        currentDot3.startAnimation(anim2)
    }

    override fun onDestroy() {
        super.onDestroy()
        currentDot2.clearAnimation()
        currentDot3.clearAnimation()
        handler.removeCallbacksAndMessages(null)
    }
}