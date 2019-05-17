package com.namget.customline.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.namget.customline.LineAdapter
import com.namget.customline.R
import com.namget.customline.data.CurrentData
import com.namget.customline.data.LineData
import com.namget.customline.data.LineItemInterface
import com.namget.customline.data.destinData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val lineList: MutableList<LineItemInterface> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
    }

    fun initRecyclerView() {
        lineList.add(CurrentData(""))
        lineList.add(LineData(""))
        lineList.add(destinData(""))
        lineList.add(LineData(""))
        lineList.add(destinData(""))
        lineList.add(LineData(""))
        lineList.add(destinData(""))


        mRecyclerView.apply {
            this.layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, true)
            this.adapter = LineAdapter(lineList)
        }

    }
}
