package com.namget.customline

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
