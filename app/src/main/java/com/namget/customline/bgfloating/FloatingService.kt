package com.namget.customline.bgfloating

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log

class FloatingService : Service() {

    lateinit var floatingHeadWindow: FloatingHeadWindow
    private val mBinder = LocalBinder()


    override fun onBind(intent: Intent?): IBinder? {
        return mBinder
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.e("myLog", "onStartCommand")
        init()
        return super.onStartCommand(intent, flags, startId)
    }


    fun init() {
        Log.e("myLog", "init")
        if (!::floatingHeadWindow.isInitialized) {
            Log.e("myLog", "is not initalized")
            floatingHeadWindow = FloatingHeadWindow(applicationContext).apply {
                create()
                createLayoutParams()
                show()
            }
        }
    }


    override fun onCreate() {
        super.onCreate()
        Log.e("myLog", "onCreate")
    }


    inner class LocalBinder : Binder() {
        fun getService(): FloatingService {
            return this@FloatingService
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        floatingHeadWindow.hide()
        Log.e("myLog", "onDestroy")
    }
}