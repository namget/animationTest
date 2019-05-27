package com.namget.customline

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.namget.customline.bgfloating.FloatingActivity
import com.namget.customline.circleview.CircleActivity
import com.namget.customline.gradation.GradationActivity
import com.namget.customline.line.LineActivity
import com.namget.customline.main.MainActivity
import com.namget.customline.scroll.ScrollActivity
import com.namget.customline.seekbar.SeekbarActivity
import kotlinx.android.synthetic.main.activity_select.*

class SelectActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select)


        startSeekbar.setOnClickListener {
            val intent = Intent(this, SeekbarActivity::class.java)
            startActivity(intent)
        }

        startRecyclerView.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        startGradient.setOnClickListener {
            val intent = Intent(this, GradationActivity::class.java)
            startActivity(intent)
        }

        startLine.setOnClickListener {
            val intent = Intent(this, LineActivity::class.java)
            startActivity(intent)
        }
        startScroll.setOnClickListener {
            val intent = Intent(this, ScrollActivity::class.java)
            startActivity(intent)
        }

        startCircle.setOnClickListener {
            val intent = Intent(this, CircleActivity::class.java)
            startActivity(intent)
        }
        startFloating.setOnClickListener {
            val intent = Intent(this, FloatingActivity::class.java)
            startActivity(intent)
        }

    }
}