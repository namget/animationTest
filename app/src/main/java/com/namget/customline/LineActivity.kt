package com.namget.customline

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.namget.customline.data.LineData
import com.namget.customline.data.LineItemInterface
import com.namget.customline.data.destinData
import kotlinx.android.synthetic.main.activity_line.*
import kotlinx.android.synthetic.main.activity_main.mRecyclerView
import kotlinx.android.synthetic.main.item_current_dot2.*

class LineActivity : AppCompatActivity() {


    val lineList: MutableList<LineItemInterface> = arrayListOf()
    val lineAdapter = LineAdapter2(lineList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_line)
        initRecyclerView()
        currentDotAnimate()
    }


    fun initRecyclerView() {

        lineList.add(LineData("", 1000))
        lineList.add(destinData(""))
        lineList.add(LineData("", 3000))
        lineList.add(destinData(""))
        lineList.add(LineData("", 4000))
        lineList.add(destinData(""))


        mRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@LineActivity, RecyclerView.VERTICAL, true)
            adapter = lineAdapter
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    if (!recyclerView.canScrollVertically(1)) {
                        myDot.visibility = View.VISIBLE
                    } else {
                        myDot.visibility = View.GONE
                    }
                }

                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    println("newState $newState")
                }
            })



        }
    }

    fun delayDown() {

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
}