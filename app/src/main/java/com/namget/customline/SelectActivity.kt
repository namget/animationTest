package com.namget.customline

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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


    }
}