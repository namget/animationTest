package com.namget.customline.recyclertest

import android.os.Bundle
import android.util.Log
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.namget.customline.R
import com.namget.customline.data.LineData
import com.namget.customline.data.LineItemInterface
import com.namget.customline.data.destinData
import kotlinx.android.synthetic.main.activity_recycler.*

class RecyclerActivity : AppCompatActivity() {


    val lineList: MutableList<LineItemInterface> = arrayListOf()
    val recyclerAdapter = RecyclerAdapter(lineList)
    var item: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)
        initRecyclerView()
//        currentDotAnimate()
    }


    fun initRecyclerView() {

        lineList.add(LineData("", 1000))
        lineList.add(destinData(""))
        lineList.add(LineData("", 1000))
        lineList.add(destinData(""))
        lineList.add(LineData("", 1000))
        lineList.add(destinData(""))
        lineList.add(LineData("", 1000))
        lineList.add(destinData(""))
        lineList.add(LineData("", 1000))
        lineList.add(destinData(""))
        lineList.add(LineData("", 1000))
        lineList.add(destinData(""))
        lineList.add(LineData("", 1000))
        lineList.add(destinData(""))



        mRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@RecyclerActivity, RecyclerView.VERTICAL, false)
            adapter = recyclerAdapter
            this.addOnScrollListener(object : RecyclerView.OnScrollListener(){
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                }

                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                }
            })
        }
        item = (lineList.size - 1)

        test()
    }

    fun test() {
        Log.e("test", "${mRecyclerView.computeVerticalScrollOffset()}")
        Log.e("test", "${mRecyclerView.measuredHeight}")
        mRecyclerView.postDelayed(
                Runnable {
                    Log.e("test", "${mRecyclerView.measuredHeight}")
                }, 1000
            )


//        if (item != 0)
//            mRecyclerView.postDelayed(
//                Runnable {
//                    mRecyclerView.smoothScrollToPosition(item - 1)
//                    item--
//                    test()
//                }, 1000
//            )

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
//        currentDot2.startAnimation(anim)
//        currentDot3.startAnimation(anim2)
    }
}